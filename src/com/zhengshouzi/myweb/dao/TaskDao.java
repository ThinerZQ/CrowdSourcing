package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface TaskDao {
    public boolean addTask(TaskEntity taskEntity);

    public List<TaskEntity> findAllTask();

    public List deleteTask(TaskEntity taskEntity);

    public boolean updateUser(UserEntity userEntity);

    public TaskEntity findTaskById(String id);
}
