package com.zhengshouzi.myweb.dao;


import com.zhengshouzi.myweb.entity.JudgetaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface JudgeTaskDao {

    boolean addJudgeTask(JudgetaskEntity judgetaskEntity);

    boolean deleteJudgeTask(JudgetaskEntity judgetaskEntity);

    boolean updateJudgeUser(JudgetaskEntity judgetaskEntity);

    List<JudgetaskEntity> findAllJudgeTask();


}
