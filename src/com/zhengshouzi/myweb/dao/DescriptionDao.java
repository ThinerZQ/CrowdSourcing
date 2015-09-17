package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.DescriptionEntity;

import java.util.ArrayList;

/**
 * Created by ǿ on 2015/9/16.
 */
public interface DescriptionDao {
    public boolean addDescriptionTask(DescriptionEntity descriptionEntity);

    public ArrayList<DescriptionEntity> findAllTask();

    public boolean deleteTask(DescriptionEntity descriptionEntity);

    public DescriptionEntity findTaskById(String id);
}
