package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.crowdsourcing.entity.JudgetaskEntity;
import com.sysu.crowdsourcing.services.JudgeTaskService;

import javax.annotation.Resource;
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
