package com.sysu.persistence.model.workflow;

import com.sysu.persistence.model.WorkflowEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 20:53
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */


public class ProcessInstanceEntity implements WorkflowEntity {


    private long id;
    private String processInstanceId;
    private String processInstanceName;
    private String processInstanceCreateTime;
    private String processInstanceCurrentState;


    private Set<UserWorkItemEntity> processInstanceUserWorkItemEntitySet;

    private Set<GroupWorkItemEntity> processInstanceGroupWorkItemEntitySet;

    public ProcessInstanceEntity(String processinstanceId, String processinstanceName, String processinstanceCreateTime) {
        this.processInstanceId = processinstanceId;
        this.processInstanceName = processinstanceName;
        this.processInstanceCreateTime = processinstanceCreateTime;
    }

    public ProcessInstanceEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public String getProcessInstanceCreateTime() {
        return processInstanceCreateTime;
    }

    public void setProcessInstanceCreateTime(String processInstanceCreateTime) {
        this.processInstanceCreateTime = processInstanceCreateTime;
    }

    public String getProcessInstanceCurrentState() {
        return processInstanceCurrentState;
    }

    public void setProcessInstanceCurrentState(String processInstanceCurrentState) {
        this.processInstanceCurrentState = processInstanceCurrentState;
    }

    public Set<UserWorkItemEntity> getProcessInstanceUserWorkItemEntitySet() {
        return processInstanceUserWorkItemEntitySet;
    }

    public void setProcessInstanceUserWorkItemEntitySet(Set<UserWorkItemEntity> processInstanceUserWorkItemEntitySet) {
        this.processInstanceUserWorkItemEntitySet = processInstanceUserWorkItemEntitySet;
    }

    public Set<GroupWorkItemEntity> getProcessInstanceGroupWorkItemEntitySet() {
        return processInstanceGroupWorkItemEntitySet;
    }

    public void setProcessInstanceGroupWorkItemEntitySet(Set<GroupWorkItemEntity> processInstanceGroupWorkItemEntitySet) {
        this.processInstanceGroupWorkItemEntitySet = processInstanceGroupWorkItemEntitySet;
    }

    public Map<String, Object> getNotNullPropertyMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getId() != 0) {
            map.put("id", getId());
        }
        if (getProcessInstanceId() != null) {
            map.put("processInstanceId", getProcessInstanceId());
        }
        if (getProcessInstanceCreateTime() != null) {
            map.put("processInstanceCreateTime", getProcessInstanceCreateTime());
        }
        if (getProcessInstanceName() != null) {
            map.put("processInstanceName", getProcessInstanceName());
        }
        if (getProcessInstanceCurrentState() != null) {
            map.put("processInstanceCurrentState", getProcessInstanceCurrentState());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;
    }
}
