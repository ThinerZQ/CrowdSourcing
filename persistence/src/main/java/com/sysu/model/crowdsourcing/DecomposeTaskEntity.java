package com.sysu.model.crowdsourcing;

import com.sysu.model.WorkflowEntity;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/19
 * Time: 15:11
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class DecomposeTaskEntity implements WorkflowEntity {

    @Id
    private long taskId;

    private Date taskCompleteTime;

    private String taskName;

    private String taskDescription;

    private String taskOrder;

    private String taskBest;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskOrder() {
        return taskOrder;
    }

    public void setTaskOrder(String taskOrder) {
        this.taskOrder = taskOrder;
    }



    public String getTaskBest() {
        return taskBest;
    }

    public void setTaskBest(String taskBest) {
        this.taskBest = taskBest;
    }

    public Map<String, Object> getNotNullPropertyMap() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getTaskName() != null) {
            map.put("taskName", getTaskName());
        }
        if (getTaskDescription() != null) {
            map.put("taskName", getTaskDescription());
        }
        if (getTaskOrder() != null) {
            map.put("taskOrder", getTaskOrder());
        }
        if (getTaskBest() != null) {
            map.put("taskBest", getTaskBest());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;
    }
}
