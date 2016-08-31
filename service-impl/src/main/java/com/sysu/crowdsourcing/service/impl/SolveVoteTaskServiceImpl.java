package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.manager.SolveVoteTaskManager;
import com.sysu.crowdsourcing.service.SolveVoteTaskService;
import com.sysu.model.crowdsourcing.SolveVoteTaskEntity;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 19:05
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SolveVoteTaskServiceImpl implements SolveVoteTaskService {

    @Resource
    SolveVoteTaskManager solveVoteTaskManager;

    public long saveSolveVoteTask(SolveVoteTaskEntity solveVoteTaskEntity) {
        return 0;
    }

    public SolveVoteTaskEntity getSolveVoteTask(SolveVoteTaskEntity solveVoteTaskEntity) {
        return solveVoteTaskEntity;
    }
}
