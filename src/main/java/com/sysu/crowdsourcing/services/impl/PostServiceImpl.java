package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.crowdsourcing.services.PostService;
import com.sysu.workflow.Evaluator;
import com.sysu.workflow.SCXMLExecutor;
import com.sysu.workflow.env.MulitStateMachineDispatcher;
import com.sysu.workflow.env.SimpleErrorReporter;
import com.sysu.workflow.env.jexl.JexlEvaluator;
import com.sysu.workflow.io.SCXMLReader;
import com.sysu.workflow.model.SCXML;

import javax.annotation.Resource;
import java.net.URL;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class PostServiceImpl implements PostService {

    @Resource(name = "taskDao")
    TaskDao taskDao;


    public boolean postTask(TaskEntity taskEntity) {

        boolean flag = taskDao.addTask(taskEntity);

        //发布成功，加载众包流程，分派任务
        if (flag) {
            try {
                URL url = this.getClass().getResource("crowdsourcingTest.xml");
                SCXML scxml = new SCXMLReader().read(url);

                //实例化数据模型解析器
                Evaluator evaluator = new JexlEvaluator();

                //实例化引擎
                SCXMLExecutor executor = new SCXMLExecutor(evaluator, new MulitStateMachineDispatcher(), new SimpleErrorReporter());

                executor.setStateMachine(scxml);

                //启动当前任务对应的状态机
                executor.go();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flag;
    }
}
