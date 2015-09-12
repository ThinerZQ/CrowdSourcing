package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.UserEntity;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface TaskDao {
    public boolean addTask(TaskEntity taskEntity);

    public ArrayList<TaskEntity> findAllTask();

    public boolean deleteTask(TaskEntity taskEntity);

    public boolean updateUser(UserEntity userEntity);

    public TaskEntity findTaskById(String id);
}
