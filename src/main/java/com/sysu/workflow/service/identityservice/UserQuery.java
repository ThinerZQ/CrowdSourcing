package com.sysu.workflow.service.identityservice;

import com.sysu.workflow.entity.UserEntity;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/12/14.
 */
public class UserQuery {

    private UserEntity user = null;
    @Resource(name = "userDao2")
    private UserDao userDao;

    public UserQuery(UserEntity user) {
        this.user = user;
    }

    public UserQuery() {
        user = new UserEntity();
    }

    public UserQuery userRealName(String realname) {
        user.setUserRealName(realname);
        return this;
    }

    public UserQuery userId(int id) {
        user.setUserId(id);
        return this;
    }

    public UserEntity SingleResult() {

        ArrayList<UserEntity> arrayList = userDao.findUser(user);
        int size = arrayList.size();
        return size >= 1 ? arrayList.get(0) : null;
    }
}
