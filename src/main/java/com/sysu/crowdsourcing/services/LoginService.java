package com.sysu.crowdsourcing.services;


import com.sysu.workflow.entity.UserEntity;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface LoginService {

     boolean login(UserEntity userEntity);

     UserEntity getUserByEmail(String email);
}
