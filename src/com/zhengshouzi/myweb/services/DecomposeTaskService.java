package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.entity.DecomposetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface DecomposeTaskService {

    List<DecomposetaskEntity> getAllDecomposeTask();
}
