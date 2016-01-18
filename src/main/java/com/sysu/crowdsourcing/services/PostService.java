package com.sysu.crowdsourcing.services;


import com.sysu.crowdsourcing.entity.TaskEntity;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface PostService {
    boolean postTask(TaskEntity taskEntity);

}
