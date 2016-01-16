package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.UserEntity;
import com.sysu.crowdsourcing.exceptions.ServiceException;


/**
 * Created by zhengshouzi on 2015/8/24.
 */
public interface RegisterService {


    boolean register(UserEntity userEntity);

    boolean processActivate(String email, String validateCode) throws ServiceException;


}
