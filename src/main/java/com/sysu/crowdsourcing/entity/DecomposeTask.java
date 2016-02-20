package com.sysu.crowdsourcing.entity;

import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.entity.WorkflowEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

@Entity
@Table(name = "t_decomposetask")
public class DecomposeTask implements WorkflowEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    private long taskId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCompleteTime;
    @Basic
    private String taskName;
    @Basic
    private String taskDescription;
    @Basic
    private String taskOrder;

    @ManyToOne()
    @JoinColumn(name = "userworkitem_id")
    private UserWorkItemEntity userWorkItemEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private DecomposeVoteTask decomposeVoteTask;


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

    public UserWorkItemEntity getUserWorkItemEntity() {
        return userWorkItemEntity;
    }

    public void setUserWorkItemEntity(UserWorkItemEntity userWorkItemEntity) {
        this.userWorkItemEntity = userWorkItemEntity;
    }

    public DecomposeVoteTask getDecomposeVoteTask() {
        return decomposeVoteTask;
    }

    public void setDecomposeVoteTask(DecomposeVoteTask decomposeVoteTask) {
        this.decomposeVoteTask = decomposeVoteTask;
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
        if (getUserWorkItemEntity() != null) {
            map.put("userWorkItemEntity", getUserWorkItemEntity());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;

    }
}
