package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.forms.RegisterForm;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public interface RegisterDao {
    public boolean register(RegisterForm registerForm);

    public RegisterForm findByEmail(String email);

    public boolean updateRegisterStatus(String email, String status);

    public boolean deleteRegisterByEmail(String Email);
}
