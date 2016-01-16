package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.TaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface TaskService {
    List<TaskEntity> getAllTask();

    // List<TaskEntity> getTheSameJudgeTaskByTaskId();
}
