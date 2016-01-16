package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.crowdsourcing.services.TaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskDao taskDao;

    @Override
    public List<TaskEntity> getAllTask() {
        return taskDao.findAllTask();
    }
}
