package com.sysu.crowdsourcing.dao;

import com.sysu.crowdsourcing.entity.DecomposetaskEntity;
import com.sysu.crowdsourcing.entity.DecomposetaskTaskEntity;
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
