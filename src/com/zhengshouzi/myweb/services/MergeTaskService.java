package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.entity.MergetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface MergeTaskService {
    List<MergetaskEntity> getAllMergeTask();
}
