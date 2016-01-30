package com.sysu.workflow.service.processservice.jdbc;

import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.service.processservice.ProcessInstanceDao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/30
 * Time: 19:46
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ProcessInstanceDaoImpl implements ProcessInstanceDao {
    public boolean addProcessInstance(ProcessInstanceEntity processInstanceEntity) {
        return false;
    }

    public ArrayList<ProcessInstanceEntity> findProcessInstanceByProcessName(String processName) {
        return null;
    }

    public ArrayList<ProcessInstanceEntity> findProcessInstance(ProcessInstanceEntity ProcessInstanceEntity) {
        return null;
    }

    public ProcessInstanceEntity findProcessInstanceByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public boolean updateProcessInstance(ProcessInstanceEntity processInstanceEntity) {
        return false;
    }

    public boolean deleteProcessInstance(ProcessInstanceEntity processInstanceEntity) {
        return false;
    }

    public ArrayList<ProcessInstanceEntity> getAllProcessInstance() {
        return null;
    }
}
