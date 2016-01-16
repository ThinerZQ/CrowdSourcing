package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.SolveTaskDao;
import com.sysu.crowdsourcing.entity.SolvetaskEntity;
import com.sysu.crowdsourcing.services.SolveTaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class SolveTaskServiceImpl implements SolveTaskService {

    @Resource(name = "solveTaskDao")
    SolveTaskDao solveTaskDao;

    @Override
    public List<SolvetaskEntity> getAllSolveTask() {
        return solveTaskDao.findAllSolveTask();
    }
}
