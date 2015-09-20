package com.zhengshouzi.myweb.services.impl;

import com.zhengshouzi.myweb.dao.DecomposeTaskDao;
import com.zhengshouzi.myweb.entity.DecomposetaskEntity;
import com.zhengshouzi.myweb.services.DecomposeTaskService;

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
