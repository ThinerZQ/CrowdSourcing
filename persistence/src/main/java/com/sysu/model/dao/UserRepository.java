package com.sysu.model.dao;


import com.sysu.model.workflow.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
