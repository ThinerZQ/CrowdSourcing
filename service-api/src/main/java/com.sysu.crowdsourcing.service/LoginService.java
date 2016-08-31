package com.sysu.crowdsourcing.service;


import com.sysu.model.workflow.UserEntity;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface LoginService {

    boolean login(UserEntity userEntity);

    UserEntity getUserByEmail(String email);
}
