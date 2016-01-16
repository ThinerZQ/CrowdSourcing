package com.sysu.crowdsourcing.entity;

import com.sysu.workflow.service.indentityservice.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "task")
public class TaskEntity {


    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long taskId;
    @Basic
    public String taskName;
    @Basic
    public String taskDescription;
    @Temporal(TemporalType.TIMESTAMP)
    public Date taskReleaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date taskDeadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date taskCompleteTime;
    @Basic
    public String taskType;
    @Basic
    public String taskPrice;


    @ManyToOne()
    @JoinColumn(name = "user_id")
    public UserEntity userEntity;


    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
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

    public Date getTaskReleaseTime() {
        return taskReleaseTime;
    }

    public void setTaskReleaseTime(Date taskReleaseTime) {
        this.taskReleaseTime = taskReleaseTime;
    }

    public Date getTaskDeadlineTime() {
        return taskDeadlineTime;
    }

    public void setTaskDeadlineTime(Date taskDeadlineTime) {
        this.taskDeadlineTime = taskDeadlineTime;
    }

    public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }

    public String getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(String taskPrice) {
        this.taskPrice = taskPrice;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }



}
