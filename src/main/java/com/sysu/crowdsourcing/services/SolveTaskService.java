package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.SolveTask;

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
    long saveSolveVote(SolveTask solveTask);

    SolveTask getSolveTask(SolveTask solveTask);

    List<SolveTask> getSolveTasks(SolveTask solveTask);

    boolean updateSolveTask(SolveTask solveTask);
}
