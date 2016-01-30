package com.sysu.workflow.service.taskservice;

import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/20
 * Time: 14:59
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class TaskService {
    @Resource(name = "userTaskQuery")
    UserTaskQuery userTaskQuery;
    @Resource(name = "groupTaskQuery")
    GroupTaskQuery groupTaskQuery;
    @Resource(name = "workItemDao")
    private WorkItemDao workItemDao;

    public UserTaskQuery createUserTaskQuery() {
        return userTaskQuery;
    }

    public GroupTaskQuery createGroupTaskQuery() {
        return groupTaskQuery;
    }

    public long saveUserWorkItem(UserWorkItemEntity workItemEntity) {

        return workItemDao.insertIntoWorkItem(workItemEntity);
    }

    public long saveGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity) {

        return workItemDao.insertIntoWorkItem(groupWorkItemEntity);
    }

    public boolean updateUserWorkItem(UserWorkItemEntity userWorkItemEntity) {

        return workItemDao.updateUserWorkItem(userWorkItemEntity);
    }

    public boolean updateGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity) {

        return workItemDao.updateGroupWorkItem(groupWorkItemEntity);
    }

    public UserWorkItemEntity newWorkItem() {
        return new UserWorkItemEntity();
    }


}
