package com.sysu.crowdsourcing.service;


import com.sysu.persistence.model.crowdsourcing.SolveTaskEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 11:01
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public interface SolveTaskService {
    long saveSolveVote(SolveTaskEntity solveTaskEntity);

    SolveTaskEntity getSolveTask(SolveTaskEntity solveTaskEntity);

    List<SolveTaskEntity> getSolveTasks(SolveTaskEntity solveTaskEntity);

    boolean updateSolveTask(SolveTaskEntity solveTaskEntity);
}
