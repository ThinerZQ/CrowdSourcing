package com.sysu.crowdsourcing.service;


import com.sysu.model.crowdsourcing.CrowdSourcingTaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface CrowdSourcingTaskService {


    CrowdSourcingTaskEntity getCrowdSourcingTaskByProcessInstanceId(long processInstanceId);

    boolean updateCrowdSourcingTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity);

    List<CrowdSourcingTaskEntity> getCrowdSourcingTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity);


}
