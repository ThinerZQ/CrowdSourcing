package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.CrowdSourcingTaskDao;
import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.crowdsourcing.services.CrowdSourcingTaskService;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class CrowdSourcingTaskServiceImpl implements CrowdSourcingTaskService {

    @Resource
    CrowdSourcingTaskDao crowdSorucingTaskDao;

    public CrowdSourcingTask getCrowdSourcingTaskByProcessInstanceId(long processInstanceId) {
        return crowdSorucingTaskDao.getCrowdSourcingTaskByProcessInstanceId(processInstanceId);
    }
}
