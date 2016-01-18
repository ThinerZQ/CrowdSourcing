package com.sysu.crowdsourcing.services;

import com.sysu.workflow.service.indentityservice.WorkItemEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface TaskService {

    List<WorkItemEntity> getAllMyWorkItem();

}
