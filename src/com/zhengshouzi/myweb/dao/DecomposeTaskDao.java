package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.DecomposetaskEntity;
import com.zhengshouzi.myweb.entity.DecomposetaskTaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface DecomposeTaskDao {
    boolean addDecomposeTask(DecomposetaskEntity decomposetaskEntity);

    boolean deleteDecomposeTaskById(String decomposeTask_id);

    boolean updateDecomposeTask(DecomposetaskTaskEntity decomposetaskTaskEntity);

    List<DecomposetaskEntity> findAllDecomposeTask();

    DecomposetaskEntity findDecomposeTaskById(String id);

    List<DecomposetaskEntity> findDecomposeTaskByCriteria(Criteria criteria);
}
