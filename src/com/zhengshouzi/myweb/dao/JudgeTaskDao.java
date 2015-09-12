package com.zhengshouzi.myweb.dao;


import com.zhengshouzi.myweb.entity.JudgetaskEntity;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface JudgeTaskDao {

    public boolean addJudgeTask(JudgetaskEntity judgetaskEntity);

    public ArrayList<JudgetaskEntity> findAllJudgeTask();

    public boolean deleteJudgeTask(JudgetaskEntity judgetaskEntity);

    public boolean updateJudgeUser(JudgetaskEntity judgetaskEntity);
}
