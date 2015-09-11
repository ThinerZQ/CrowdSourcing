package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.entity.JudgetaskEntity;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface JudgeTaskService {

    public ArrayList<JudgetaskEntity> getSystemAllJudgeTask();
    public ArrayList<JudgetaskEntity> getTheSameJudgeTaskByTaskId();








}
