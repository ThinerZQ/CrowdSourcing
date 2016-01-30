package com.sysu.workflow.service.identityservice;

import com.sysu.workflow.entity.GroupEntity;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 14:59
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class GroupQuery {

    private GroupEntity group = null;

    @Resource(name = "groupDao")
    private GroupDao groupDaoImpl;

    public GroupQuery(GroupEntity group) {
        this.group = group;
    }

    public GroupQuery() {
        group = new GroupEntity();
    }

    public GroupQuery groupName(String groupName) {
        group.setGroupName(groupName);
        return this;
    }

    public GroupQuery groupId(int id) {
        group.setGroupId(id);
        return this;
    }

    public GroupEntity SingleResult() {
        ArrayList<GroupEntity> groupEntityArrayList = groupDaoImpl.findGroup(group);
        int size = groupEntityArrayList.size();
        return size >= 1 ? groupEntityArrayList.get(0) : null;
    }
}
