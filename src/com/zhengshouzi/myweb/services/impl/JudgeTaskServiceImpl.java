package com.zhengshouzi.myweb.services.impl;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.entity.JudgetaskEntity;
import com.zhengshouzi.myweb.services.JudgeTaskService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class JudgeTaskServiceImpl implements JudgeTaskService {

    @Resource
    JudgeTaskDao judgeTaskDao;

    @Override
    public List<JudgetaskEntity> getAllJudgeTask() {
        return judgeTaskDao.findAllJudgeTask();
    }
}
