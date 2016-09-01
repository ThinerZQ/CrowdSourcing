package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.manager.DecomposeVoteTaskManager;
import com.sysu.crowdsourcing.service.DecomposeVoteTaskService;
import com.sysu.persistence.model.crowdsourcing.DecomposeVoteTaskEntity;

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

    @Resource
    DecomposeVoteTaskManager decomposeVoteTaskManager;


    public long saveDecomposeVoteTask(DecomposeVoteTaskEntity decomposeVoteTaskEntity) {
        return 0;
    }

    public DecomposeVoteTaskEntity getDecomposeVoteTasks(DecomposeVoteTaskEntity decomposeVoteTaskEntity) {
        return decomposeVoteTaskEntity;
    }
}
