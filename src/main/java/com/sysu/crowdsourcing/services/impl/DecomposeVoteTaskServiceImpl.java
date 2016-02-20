package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.DecomposeVoteTaskDao;
import com.sysu.crowdsourcing.entity.DecomposeVoteTask;
import com.sysu.crowdsourcing.services.DecomposeVoteTaskService;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 13:23
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class DecomposeVoteTaskServiceImpl implements DecomposeVoteTaskService {

    @Resource(name = "decomposeVoteTaskDao")
    DecomposeVoteTaskDao decomposeVoteTaskDao;


    public long saveDecomposeVoteTask(DecomposeVoteTask decomposeVoteTask) {
        return decomposeVoteTaskDao.saveDecomposeVoteTask(decomposeVoteTask);
    }

    public DecomposeVoteTask getDecomposeVoteTasks(DecomposeVoteTask decomposeVoteTask) {
        return decomposeVoteTaskDao.getDecomposeVoteTasks(decomposeVoteTask);
    }
}
