package com.sysu.workflow.service.identityservice;

import com.sysu.workflow.entity.GroupEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/30
 * Time: 19:34
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public interface GroupDao {

    boolean addGroup(GroupEntity groupEntity);


    ArrayList<GroupEntity> findGroup(GroupEntity groupEntity);

    ArrayList<GroupEntity> findGroupByGroupName(String groupName);

    ArrayList<GroupEntity> findGroupByGroupId(String groupId);

    boolean updateGroup(GroupEntity groupEntity);

    boolean deleteGroup(GroupEntity groupEntity);

    public boolean deleteGroupById(String groupId);
}
