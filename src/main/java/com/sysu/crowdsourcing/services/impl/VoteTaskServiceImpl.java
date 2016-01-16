package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.VoteTaskDao;
import com.sysu.crowdsourcing.entity.VotetaskEntity;
import com.sysu.crowdsourcing.services.VoteTaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class VoteTaskServiceImpl implements VoteTaskService {

    @Resource(name = "voteTaskDao")
    VoteTaskDao voteTaskDao;

    @Override
    public List<VotetaskEntity> getAllVoteTask() {
        return voteTaskDao.findAllVoteTask();
    }
}
