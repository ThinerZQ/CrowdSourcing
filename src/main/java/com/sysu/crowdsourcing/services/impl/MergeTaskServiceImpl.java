package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.MergeTaskDao;
import com.sysu.crowdsourcing.services.MergeTaskService;
import com.sysu.crowdsourcing.entity.MergetaskEntity;

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
