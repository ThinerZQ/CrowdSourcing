package com.sysu.crowdsourcing.service;


import com.sysu.model.crowdsourcing.CrowdSourcingTaskEntity;

import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface PostService {
    boolean postTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity);

    boolean saveCrowdSourcingTask(CrowdSourcingTaskEntity crowdSourcingTaskEntity);

    boolean saveCrowdSourcingTask(Set<CrowdSourcingTaskEntity> crowdSourcingTaskEntityArrayList);
}
