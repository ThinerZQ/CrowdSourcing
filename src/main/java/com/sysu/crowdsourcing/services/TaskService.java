package com.sysu.crowdsourcing.services;


import com.sysu.workflow.entity.UserWorkItemEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface TaskService {

    List<UserWorkItemEntity> getAllMyWorkItem();

}
