package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.beans.JudgeTask;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface JudgeTaskService {

    public ArrayList<JudgeTask> getSystemAllJudgeTask();
    public ArrayList<JudgeTask> getTheSameJudgeTaskByTaskId();








}
