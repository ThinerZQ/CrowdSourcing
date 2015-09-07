package com.zhengshouzi.myweb.dao;


import com.zhengshouzi.myweb.beans.JudgeTask;
import com.zhengshouzi.myweb.beans.Task;
import com.zhengshouzi.myweb.beans.User;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface JudgeTaskDao {

    public boolean addJudgeTask(JudgeTask judgeTask);
    public ArrayList<JudgeTask> findAllJudgeTask();
    public boolean deleteJudgeTask(JudgeTask judgeTask);
    public boolean updateJudgeUser(JudgeTask judgeTask);
}
