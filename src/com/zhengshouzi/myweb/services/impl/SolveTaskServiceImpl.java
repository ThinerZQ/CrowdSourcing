package com.zhengshouzi.myweb.services.impl;

import com.zhengshouzi.myweb.dao.SolveTaskDao;
import com.zhengshouzi.myweb.entity.SolvetaskEntity;
import com.zhengshouzi.myweb.services.SolveTaskService;

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
