package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.SolveVoteTask;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 11:01
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public interface SolveVoteTaskService {
    long saveSolveVoteTask(SolveVoteTask solveVoteTask);

    SolveVoteTask getSolveVoteTask(SolveVoteTask solveVoteTask);
}
