package com.sysu.model.crowdsourcing.dao;

import com.sysu.model.crowdsourcing.entity.SolveVoteTask;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 19:05
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public interface SolveVoteTaskDao {
    long saveSolveVoteTask(SolveVoteTask solveVoteTask);

    SolveVoteTask getSolveVoteTask(SolveVoteTask solveVoteTask);
}
