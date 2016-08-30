package com.sysu.crowdsourcing.service.impl;

import com.sysu.model.crowdsourcing.dao.SolveTaskDao;
import com.sysu.model.crowdsourcing.entity.SolveTask;
import com.sysu.model.crowdsourcing.services.SolveTaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 11:04
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SolveTaskServiceImpl implements SolveTaskService {

    @Resource
    SolveTaskDao solveTaskDao;

    public long saveSolveVote(SolveTask solveTask) {
        return solveTaskDao.saveSolveVote(solveTask);
    }

    public SolveTask getSolveTask(SolveTask solveTask) {
        return solveTaskDao.getSolveTask(solveTask);
    }

    public List<SolveTask> getSolveTasks(SolveTask solveTask) {
        return solveTaskDao.getSolveTasks(solveTask);
    }

    public boolean updateSolveTask(SolveTask solveTask) {
        return solveTaskDao.updateSolveTask(solveTask);
    }
}
