package com.sysu.workflow.service.taskservice.jdbc;

import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.service.taskservice.WorkItemDao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/30
 * Time: 19:49
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class WorkItemDaoImpl implements WorkItemDao {
    public long insertIntoWorkItem(UserWorkItemEntity workItemEntity) {
        return 0;
    }

    public long insertIntoWorkItem(GroupWorkItemEntity workItemEntity) {
        return 0;
    }

    public ArrayList<UserWorkItemEntity> findUserWorkItem(UserWorkItemEntity userWorkItemEntity) {
        return null;
    }

    public ArrayList<GroupWorkItemEntity> findGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity) {
        return null;
    }

    public boolean updateUserWorkItem(UserWorkItemEntity userWorkItemEntity) {
        return false;
    }

    public boolean updateGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity) {
        return false;
    }
}
