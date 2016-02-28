package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.CrowdSourcingTaskDao;
import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.crowdsourcing.services.PostService;
import com.sysu.workflow.Context;
import com.sysu.workflow.Evaluator;
import com.sysu.workflow.SCXMLExecutor;
import com.sysu.workflow.SCXMLSystemContext;
import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.env.MulitStateMachineDispatcher;
import com.sysu.workflow.env.SimpleErrorReporter;
import com.sysu.workflow.env.jexl.JexlEvaluator;
import com.sysu.workflow.io.SCXMLReader;
import com.sysu.workflow.model.SCXML;
import com.sysu.workflow.service.processservice.RuntimeService;

import javax.annotation.Resource;
import java.net.URL;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class PostServiceImpl implements PostService {

    @Resource(name = "crowdSourcingTaskDao")
    CrowdSourcingTaskDao crowdSorucingTaskDao;


    public boolean postTask(CrowdSourcingTask crowdSourcingTask) {

        long id = -1;
        boolean flag = false;
        //发布成功，加载众包流程，分派任务

        try {
            URL url = this.getClass().getClassLoader().getResource("crowdsourcingTest.xml");
            SCXML scxml = new SCXMLReader().read(url);
            //实例化数据模型解析器
            Evaluator evaluator = new JexlEvaluator();
            //实例化引擎
            SCXMLExecutor executor = new SCXMLExecutor(evaluator, new MulitStateMachineDispatcher(), new SimpleErrorReporter());
            executor.setStateMachine(scxml);

            //将当前的crowdsourcingTask 设置为根上下文
            Context rootContext = evaluator.newContext(null);
            rootContext.set("crowdSourcingTask", crowdSourcingTask);
            executor.setRootContext(rootContext);
            System.out.println(crowdSourcingTask.toString());
            //启动当前任务对应的状态机
            executor.go();
            ProcessInstanceEntity processInstanceEntity = RuntimeService.createProcessInstanceQuery().processInstanceId((String) executor.getGlobalContext().getSystemContext().get(SCXMLSystemContext.SESSIONID_KEY)).SingleResult();
            crowdSourcingTask.setProcessInstanceEntity(processInstanceEntity);


            id = crowdSorucingTaskDao.addTask(crowdSourcingTask);

            CrowdSourcingTask fulCrowdSourcingTask = crowdSorucingTaskDao.findTaskById(id + "");
            rootContext.set("crowdSourcingTask", fulCrowdSourcingTask);

            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (id != -1) {
                crowdSorucingTaskDao.deleteTaskById(id);
            }
            flag = false;
        }

        return flag;
    }

    public boolean saveCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask) {

        return crowdSorucingTaskDao.addTask(crowdSourcingTask) != -1 ? true : false;
    }

    public boolean saveCrowdSourcingTask(Set<CrowdSourcingTask> crowdSourcingTaskArrayList) {


        return crowdSorucingTaskDao.addTask(crowdSourcingTaskArrayList);
    }
}
