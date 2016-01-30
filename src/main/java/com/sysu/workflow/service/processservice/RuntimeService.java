package com.sysu.workflow.service.processservice;

import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.service.processservice.jdbc.ProcessInstanceDaoImpl;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 21:03
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class RuntimeService {
    @Resource(name = "processInstanceDao")
    ProcessInstanceDao processInstanceDaoImpl;

    @Resource(name = "processInstanceQuery")
    ProcessInstanceQuery processInstanceQuery;

    public ProcessInstanceQuery createProcessInstanceQuery() {
        return processInstanceQuery;
    }

    public boolean saveProcessInstance(ProcessInstanceEntity processInstanceEntity) {

        // non spring initial bean :processInstanceDao
        if (processInstanceDaoImpl == null) {
            processInstanceDaoImpl = new ProcessInstanceDaoImpl();
        }
        return processInstanceDaoImpl.addProcessInstance(processInstanceEntity);
    }

    public boolean updateProcessInstance() {

        return false;
    }

    public ProcessInstanceEntity newProcessInstance() {
        return new ProcessInstanceEntity();
    }

    public ProcessInstanceEntity newProcessInstance(String processInstanceId, String processInstanceName, String processInstanceCreateTime) {
        return new ProcessInstanceEntity(processInstanceId, processInstanceName, processInstanceCreateTime);
    }
}
