package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.entity.UserEntity;
import com.zhengshouzi.myweb.exceptions.ServiceException;


/**
 * Created by zhengshouzi on 2015/8/24.
 */
public interface RegisterService {


    boolean register(UserEntity userEntity);

    boolean processActivate(String email, String validateCode) throws ServiceException;


}
