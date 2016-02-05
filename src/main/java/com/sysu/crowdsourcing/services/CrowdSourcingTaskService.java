package com.sysu.crowdsourcing.services;


import com.sysu.crowdsourcing.entity.CrowdSourcingTask;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface CrowdSourcingTaskService {


    CrowdSourcingTask getCrowdSourcingTaskByProcessInstanceId(long processInstanceId);


}
