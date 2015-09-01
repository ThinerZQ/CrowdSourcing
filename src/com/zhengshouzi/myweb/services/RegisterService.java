package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.exceptions.ServiceException;
import com.zhengshouzi.myweb.forms.RegisterForm;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public interface RegisterService {


    public boolean register(RegisterForm registerForm);

    public boolean processActivate(String email, String validateCode) throws ServiceException;


}
