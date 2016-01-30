package com.sysu.workflow.service.identityservice.jdbc;

import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.service.identityservice.GroupDao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2015/12/16
 * Time: 13:17
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class GroupDaoImpl implements GroupDao {

    public boolean addGroup(GroupEntity groupEntity) {
        return false;
    }


    public ArrayList<GroupEntity> findGroup(GroupEntity groupEntity) {
        return null;
    }

    public ArrayList<GroupEntity> findGroupByGroupName(String groupName) {


        return null;

    }

    public ArrayList<GroupEntity> findGroupByGroupId(String groupId) {

        return null;
    }

    public boolean updateGroup(GroupEntity groupEntity) {
        return false;
    }

    public boolean deleteGroup(GroupEntity groupEntity) {
        return false;
    }

    public boolean deleteGroupById(String groupId) {
        return false;
    }


}
