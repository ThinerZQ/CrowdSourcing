package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.VotetaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface VoteTaskService {
    List<VotetaskEntity> getAllVoteTask();
}
