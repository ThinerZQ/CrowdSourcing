package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.manager.SolveTaskManager;
import com.sysu.crowdsourcing.service.SolveTaskService;
import com.sysu.persistence.model.crowdsourcing.SolveTaskEntity;

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
    SolveTaskManager solveTaskManager;

    public long saveSolveVote(SolveTaskEntity solveTaskEntity) {
        return 0;
    }

    public SolveTaskEntity getSolveTask(SolveTaskEntity solveTaskEntity) {
        return solveTaskEntity;
    }

    public List<SolveTaskEntity> getSolveTasks(SolveTaskEntity solveTaskEntity) {
        return null;
    }


    public boolean updateSolveTask(SolveTaskEntity solveTaskEntity) {
        return false;
    }
}
