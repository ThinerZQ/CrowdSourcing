package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.SolvetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface SolveTaskDao {
    boolean addSolveTask(SolvetaskEntity solvetaskEntity);

    boolean deleteSolveTaskById(String solveTask_id);

    boolean updateSolveTask(SolvetaskEntity solvetaskEntity);

    List<SolvetaskEntity> findAllSolveTask();

    TaskEntity findSolveTaskById(String solveTask_id);

    List<SolvetaskEntity> findSolveTaskByCriteria(Criteria criteria);
}
