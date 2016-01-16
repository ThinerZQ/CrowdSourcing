package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.VotetaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface VoteTaskService {
    List<VotetaskEntity> getAllVoteTask();
}
