package com.sysu.model.workflow;

import com.sysu.model.WorkflowEntity;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/16
 * Time: 16:09
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class GroupEntity implements WorkflowEntity {
    @Id
    private long groupId;

    private String groupName;

    private Set<UserEntity> userEntitySet = new HashSet<UserEntity>();


    private Set<GroupWorkItemEntity> workItemEntitySet = new HashSet<GroupWorkItemEntity>();

    public GroupEntity(String name) {
        this.groupName = name;
    }

    public GroupEntity() {
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<UserEntity> getUserEntitySet() {
        return userEntitySet;
    }

    public void setUserEntitySet(Set<UserEntity> userEntitySet) {
        this.userEntitySet = userEntitySet;
    }


    public Map<String, Object> getNotNullPropertyMap() {
        return null;
    }
}
