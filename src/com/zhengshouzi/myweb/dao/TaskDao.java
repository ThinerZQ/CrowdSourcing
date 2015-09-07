package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.beans.Task;
import com.zhengshouzi.myweb.beans.User;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface TaskDao {
    public boolean addTask(Task task);
    public ArrayList<Task> findAllTask();
    public boolean deleteTask(Task task);
    public boolean updateUser(User user);
    public Task findTaskById(String id);
}
