package com.sysu.crowdsourcing.service;


import com.sysu.persistence.model.crowdsourcing.SolveVoteTaskEntity;

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
    long saveSolveVoteTask(SolveVoteTaskEntity solveVoteTaskEntity);

    SolveVoteTaskEntity getSolveVoteTask(SolveVoteTaskEntity solveVoteTaskEntity);
}
