package com.sysu.crowdsourcing.dao;


import com.sysu.crowdsourcing.entity.JudgetaskEntity;

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
