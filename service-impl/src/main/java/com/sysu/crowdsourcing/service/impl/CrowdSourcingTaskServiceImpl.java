package com.sysu.crowdsourcing.service.impl;

import com.sysu.model.crowdsourcing.dao.CrowdSourcingTaskDao;
import com.sysu.model.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.model.crowdsourcing.services.CrowdSourcingTaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class CrowdSourcingTaskServiceImpl implements CrowdSourcingTaskService {

    @Resource
    CrowdSourcingTaskDao crowdSourcingTaskDao;

    public CrowdSourcingTask getCrowdSourcingTaskByProcessInstanceId(long processInstanceId) {
        return crowdSourcingTaskDao.getCrowdSourcingTaskByProcessInstanceId(processInstanceId);
    }

    public boolean updateCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask) {
        return crowdSourcingTaskDao.updateCrowdSourcingTask(crowdSourcingTask);
    }

    public List<CrowdSourcingTask> getCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask) {
        return crowdSourcingTaskDao.getCrowdSourcingTask(crowdSourcingTask);
    }
}
