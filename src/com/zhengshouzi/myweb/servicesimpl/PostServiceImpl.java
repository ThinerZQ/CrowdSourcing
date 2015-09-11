package com.zhengshouzi.myweb.servicesimpl;

import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.services.PostService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class PostServiceImpl implements PostService {

    @Resource(name = "taskDao")
    TaskDao taskDao;
    @Override
    public boolean postTask(TaskEntity task) {


        task.setReleaseTime(new Timestamp(new Date().getTime()));



        return taskDao.addTask(task);
    }
}
