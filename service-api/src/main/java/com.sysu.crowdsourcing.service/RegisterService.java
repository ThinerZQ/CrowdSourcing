package com.sysu.crowdsourcing.service;


import com.sysu.model.workflow.UserEntity;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public interface RegisterService {


    boolean register(UserEntity userEntity);

    boolean processActivate(String email, String validateCode);


}
