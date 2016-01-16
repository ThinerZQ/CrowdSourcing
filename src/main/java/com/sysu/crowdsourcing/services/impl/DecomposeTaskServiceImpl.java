package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.DecomposeTaskDao;
import com.sysu.crowdsourcing.entity.DecomposetaskEntity;
import com.sysu.crowdsourcing.services.DecomposeTaskService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class DecomposeTaskServiceImpl implements DecomposeTaskService {

    @Resource(name = "decomposeTaskDao")
    DecomposeTaskDao decomposeTaskDao;

    @Override
    public List<DecomposetaskEntity> getAllDecomposeTask() {
        return decomposeTaskDao.findAllDecomposeTask();
    }
}
