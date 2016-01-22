package com.sysu.crowdsourcing.dao;

import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface TaskDao {
    long addTask(TaskEntity taskEntity);

    boolean deleteTaskById(long taskId);

    boolean updateTask(TaskEntity taskEntity);

    TaskEntity findTaskById(String id);

    List<TaskEntity> findTaskByCriteria(Criteria criteria);

    List<UserWorkItemEntity> findAllWorkitem();



}
