package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.manager.CrowdSourcingTaskManager;
import com.sysu.crowdsourcing.service.PostService;
import com.sysu.persistence.model.crowdsourcing.CrowdSourcingTaskEntity;
import com.sysu.workflow.Context;
import com.sysu.workflow.Evaluator;
import com.sysu.workflow.SCXMLExecutor;
import com.sysu.workflow.env.MulitStateMachineDispatcher;
import com.sysu.workflow.env.SimpleErrorReporter;
import com.sysu.workflow.env.jexl.JexlEvaluator;
import com.sysu.workflow.io.SCXMLReader;
import com.sysu.workflow.model.SCXML;

import javax.annotation.Resource;
import java.net.URL;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class PostServiceImpl implements PostService {

    @Resource
    CrowdSourcingTaskManager crowdSourcingTaskManager;


    public boolean postTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity) {

        long id = -1;
        boolean flag = false;
        // post task
        try {
            URL url = this.getClass().getClassLoader().getResource("crowdsourcingTest.xml");
            SCXML scxml = new SCXMLReader().read(url);
            Evaluator evaluator = new JexlEvaluator();
            SCXMLExecutor executor = new SCXMLExecutor(evaluator, new MulitStateMachineDispatcher(), new SimpleErrorReporter());
            executor.setStateMachine(scxml);

            Context rootContext = evaluator.newContext(null);
            rootContext.set("crowdSourcingTaskEntity", crowdSourcingTaskEntity);
            executor.setRootContext(rootContext);
            System.out.println(crowdSourcingTaskEntity.toString());

            executor.go();
           /* ProcessInstanceEntity processInstanceEntity = RuntimeService.createProcessInstanceQuery().processInstanceId((String) executor.getGlobalContext().getSystemContext().get(SCXMLSystemContext.SESSIONID_KEY)).SingleResult();
            crowdSourcingTaskEntity.setProcessInstanceEntity(processInstanceEntity);*/


           /* //id = crowdSourcingTaskManager.addTask(crowdSourcingTaskEntity);

            CrowdSourcingTaskEntity fulCrowdSourcingTask = crowdSorucingTaskDao.findTaskById(id + "");
            rootContext.set("crowdSourcingTaskEntity", fulCrowdSourcingTask);*/

            flag = true;
        } catch (Exception e) {

        }

        return flag;
    }

    public boolean saveCrowdSourcingTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity) {

        //return crowdSourcingTaskManager.addTask(crowdSourcingTaskEntity) != -1 ? true : false;
        return false;
    }

    public boolean saveCrowdSourcingTask(Set<CrowdSourcingTaskEntity> crowdSourcingTaskEntityArrayList) {


        //return crowdSourcingTaskManager.addTask(crowdSourcingTaskEntityArrayList);
        return false;
    }
}
