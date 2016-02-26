package com.sysu.crowdsourcing.dao;

import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.workflow.entity.UserWorkItemEntity;
import org.hibernate.Criteria;

import java.util.List;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface CrowdSourcingTaskDao {
    long addTask(CrowdSourcingTask crowdSourcingTask);

    boolean addTask(Set<CrowdSourcingTask> crowdSourcingTaskArrayList);

    boolean deleteTaskById(long taskId);

    CrowdSourcingTask getCrowdSourcingTaskByProcessInstanceId(long processInstanceId);

    boolean updateCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask);

    List<CrowdSourcingTask> getCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask);




    boolean updateTask(CrowdSourcingTask crowdSourcingTask);

    CrowdSourcingTask findTaskById(String id);

    List<CrowdSourcingTask> findTaskByCriteria(Criteria criteria);

    List<UserWorkItemEntity> findAllWorkitem();


}
