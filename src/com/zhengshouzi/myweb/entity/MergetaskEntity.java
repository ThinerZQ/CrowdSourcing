package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "mergetask")
public class MergetaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;
    @Basic
    public String finalResult;
    @Basic
    public String price;
    @Temporal(TemporalType.TIMESTAMP)
    public Date releaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date deadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date completeTime;

    @ManyToOne()
    @JoinColumn(name = "task_id")
    public TaskEntity taskEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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


    @Override
    public String toString() {
        return "MergetaskEntity{" +
                "id=" + id +
                ", finalResult='" + finalResult + '\'' +
                ", releaseTime=" + releaseTime +
                ", deadlineTime=" + deadlineTime +
                ", completeTime=" + completeTime +
                ", taskEntity=" + taskEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MergetaskEntity that = (MergetaskEntity) o;

        if (id != that.id) return false;
        if (finalResult != null ? !finalResult.equals(that.finalResult) : that.finalResult != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;
        return !(taskEntity != null ? !taskEntity.equals(that.taskEntity) : that.taskEntity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (finalResult != null ? finalResult.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (taskEntity != null ? taskEntity.hashCode() : 0);
        return result;
    }
}
