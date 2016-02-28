package com.sysu.crowdsourcing.services;


import com.sysu.crowdsourcing.entity.CrowdSourcingTask;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface CrowdSourcingTaskService {


    CrowdSourcingTask getCrowdSourcingTaskByProcessInstanceId(long processInstanceId);

    boolean updateCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask);

    List<CrowdSourcingTask> getCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask);


}
