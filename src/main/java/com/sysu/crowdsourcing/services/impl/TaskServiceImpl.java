package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.services.TaskService;
import com.sysu.workflow.entity.UserWorkItemEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskDao taskDao;

    public List<UserWorkItemEntity> getAllMyWorkItem() {
        return taskDao.findAllWorkitem();
    }
}
