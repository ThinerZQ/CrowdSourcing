package com.sysu.workflow.service.identityservice;

import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.entity.UserEntity;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2015/12/14
 * Time: 13:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class IdentityService {

    @Resource(name = "userDao2")
    UserDao userDao = null;
    @Resource(name = "groupDao")
    GroupDao groupDaoImpl = null;

    @Resource(name = "userQuery")
    UserQuery userQuery;

    @Resource(name = "groupQuery")
    GroupQuery groupQuery;

    public UserQuery createUserQuery() {

        return userQuery;
    }

    public GroupQuery createGroupQuery() {

        return groupQuery;
    }

    public UserEntity newUser(String realname) {
        return new UserEntity(realname);
    }

    public UserEntity newUser() {
        return new UserEntity();
    }

    public boolean saveUser(UserEntity userEntity) {

        return userDao.addUsers(userEntity);
    }

    public boolean checkUser(UserEntity userEntity) {

        return userDao.checkUser(userEntity.getUserEmail(), userEntity.getUserPassword());
    }

    public boolean delete() {
        return false;
    }

    public boolean update() {
        return false;
    }

    public GroupEntity newGroup(String name) {
        return new GroupEntity(name);
    }

    public boolean saveGroup(GroupEntity group) {

        return groupDaoImpl.addGroup(group);
    }

}
