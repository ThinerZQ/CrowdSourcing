package com.zhengshouzi.myweb.services.impl;

import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.services.TaskService;

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
