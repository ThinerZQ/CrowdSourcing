package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.UserEntity;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface LoginService {

    public boolean login(UserEntity userEntity);

    public UserEntity getUserByEmail(String email);
}
