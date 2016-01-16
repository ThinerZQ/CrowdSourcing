package com.sysu.crowdsourcing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "judgetask")
public class JudgetaskEntity {
    @Basic
    public String price;
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    private long id;
    @Basic
    private String simple;
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date completeTime;
    @ManyToOne()
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "JudgetaskEntity{" +
                "id=" + id +
                ", simple='" + simple + '\'' +
                ", releaseTime=" + releaseTime +
                ", deadlineTime=" + deadlineTime +
                ", completeTime=" + completeTime +
                ", taskEntity=" + taskEntity +
                ", userEntity=" + userEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JudgetaskEntity that = (JudgetaskEntity) o;

        if (id != that.id) return false;
        if (simple != null ? !simple.equals(that.simple) : that.simple != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;
        if (taskEntity != null ? !taskEntity.equals(that.taskEntity) : that.taskEntity != null) return false;
        return !(userEntity != null ? !userEntity.equals(that.userEntity) : that.userEntity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (simple != null ? simple.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (taskEntity != null ? taskEntity.hashCode() : 0);
        result = 31 * result + (userEntity != null ? userEntity.hashCode() : 0);
        return result;
    }
}
