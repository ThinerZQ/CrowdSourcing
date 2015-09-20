package com.zhengshouzi.myweb.services.impl;

import com.zhengshouzi.myweb.dao.VoteTaskDao;
import com.zhengshouzi.myweb.entity.VotetaskEntity;
import com.zhengshouzi.myweb.services.VoteTaskService;

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
