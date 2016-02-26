package com.sysu.crowdsourcing.services;


import com.sysu.crowdsourcing.entity.CrowdSourcingTask;

import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface PostService {
    boolean postTask(CrowdSourcingTask crowdSourcingTask);

    boolean saveCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask);

    boolean saveCrowdSourcingTask(Set<CrowdSourcingTask> crowdSourcingTaskArrayList);
}
