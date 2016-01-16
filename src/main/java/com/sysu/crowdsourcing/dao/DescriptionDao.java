package com.sysu.crowdsourcing.dao;

import com.sysu.crowdsourcing.entity.DescriptionEntity;

import java.util.List;

/**
 * Created by ǿ on 2015/9/16.
 */
public interface DescriptionDao {

    boolean addDescription(DescriptionEntity descriptionEntity);

    boolean deleteDescription(DescriptionEntity descriptionEntity);

    boolean updateDescription(DescriptionEntity descriptionEntity);

    List<DescriptionEntity> findAllTask();

    DescriptionEntity findDescriptionById(String id);


}
