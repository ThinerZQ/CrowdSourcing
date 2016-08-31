package com.sysu.crowdsourcing.service.impl;

import com.sysu.crowdsourcing.manager.CrowdSourcingTaskManager;
import com.sysu.crowdsourcing.service.CrowdSourcingTaskService;
import com.sysu.model.crowdsourcing.CrowdSourcingTaskEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class CrowdSourcingTaskServiceImpl implements CrowdSourcingTaskService {

    @Resource
    CrowdSourcingTaskManager crowdSourcingTaskManager;

    public CrowdSourcingTaskEntity getCrowdSourcingTaskByProcessInstanceId(long processInstanceId) {
        return null;
    }

    public boolean updateCrowdSourcingTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity) {
        return false;
    }

    public List<CrowdSourcingTaskEntity> getCrowdSourcingTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity) {
        return null;
    }
}
