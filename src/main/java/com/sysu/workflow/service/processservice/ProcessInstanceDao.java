package com.sysu.workflow.service.processservice;

import com.sysu.workflow.entity.ProcessInstanceEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 21:10
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public interface ProcessInstanceDao {

    boolean addProcessInstance(ProcessInstanceEntity processInstanceEntity);

    ArrayList<ProcessInstanceEntity> findProcessInstanceByProcessName(String processName);

    ArrayList<ProcessInstanceEntity> findProcessInstance(ProcessInstanceEntity ProcessInstanceEntity);

    ProcessInstanceEntity findProcessInstanceByProcessInstanceId(String processInstanceId);

    boolean updateProcessInstance(ProcessInstanceEntity processInstanceEntity);

    boolean deleteProcessInstance(ProcessInstanceEntity processInstanceEntity);

    ArrayList<ProcessInstanceEntity> getAllProcessInstance();
}
