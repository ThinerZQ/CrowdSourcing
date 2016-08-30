package com.sysu.model.crowdsourcing;

import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.entity.WorkflowEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 12:56
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
@Entity
@Table(name = "t_judgetask")
public class JudgeTask implements WorkflowEntity {


    @OneToOne()
    @JoinColumn(name = "userworkitem_id")
    public UserWorkItemEntity userWorkItemEntity;
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    private long taskId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCompleteTime;
    @Basic
    private String property;

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

    public UserWorkItemEntity getUserWorkItemEntity() {
        return userWorkItemEntity;
    }

    public void setUserWorkItemEntity(UserWorkItemEntity userWorkItemEntity) {
        this.userWorkItemEntity = userWorkItemEntity;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "JudgeTask{" +
                "taskId=" + taskId +
                ", taskCompleteTime=" + taskCompleteTime +
                ", property='" + property + '\'' +
                ", userWorkItemEntity=" + userWorkItemEntity +
                '}';
    }

    public Map<String, Object> getNotNullPropertyMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getProperty() != null) {
            map.put("property", getProperty());
        }
        if (getUserWorkItemEntity() != null) {
            map.put("userWorkItemEntity", getUserWorkItemEntity());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;
    }
}
