package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.TaskEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface TaskDao {
    boolean addTask(TaskEntity taskEntity);

    boolean deleteTaskById(String task_id);

    boolean updateTask(TaskEntity taskEntity);

    List<TaskEntity> findAllTask();

    TaskEntity findTaskById(String id);

    List<TaskEntity> findTaskByCriteria(Criteria criteria);
}
