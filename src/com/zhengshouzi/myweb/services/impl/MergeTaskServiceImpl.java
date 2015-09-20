package com.zhengshouzi.myweb.services.impl;

import com.zhengshouzi.myweb.dao.MergeTaskDao;
import com.zhengshouzi.myweb.entity.MergetaskEntity;
import com.zhengshouzi.myweb.services.MergeTaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class MergeTaskServiceImpl implements MergeTaskService {

    @Resource(name = "mergeTaskDao")
    MergeTaskDao mergeTaskDao;

    @Override
    public List<MergetaskEntity> getAllMergeTask() {
        return mergeTaskDao.findAllMergeTask();
    }
}
