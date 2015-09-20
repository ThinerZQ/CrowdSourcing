package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "solvetask")
public class SolvetaskEntity {
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;
    @Basic
    public String result;
    @Basic
    public String best;
    @Temporal(TemporalType.TIMESTAMP)
    public Date releaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date deadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date completeTime;

    @ManyToOne()
    @JoinColumn(name = "task_id")
    public TaskEntity taskEntity;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    public UserEntity userEntity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "solvetask_id")
    public Set<VotetaskSolvetaskEntity> votetaskSolvetaskEntitySet = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
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

    public Set<VotetaskSolvetaskEntity> getVotetaskSolvetaskEntitySet() {
        return votetaskSolvetaskEntitySet;
    }

    public void setVotetaskSolvetaskEntitySet(Set<VotetaskSolvetaskEntity> votetaskSolvetaskEntitySet) {
        this.votetaskSolvetaskEntitySet = votetaskSolvetaskEntitySet;
    }

    @Override
    public String toString() {
        return "SolvetaskEntity{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", best='" + best + '\'' +
                ", releaseTime=" + releaseTime +
                ", deadlineTime=" + deadlineTime +
                ", completeTime=" + completeTime +
                ", taskEntity=" + taskEntity +
                ", userEntity=" + userEntity +
                ", votetaskSolvetaskEntitySet=" + votetaskSolvetaskEntitySet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolvetaskEntity that = (SolvetaskEntity) o;

        if (id != that.id) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (best != null ? !best.equals(that.best) : that.best != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;
        if (taskEntity != null ? !taskEntity.equals(that.taskEntity) : that.taskEntity != null) return false;
        if (userEntity != null ? !userEntity.equals(that.userEntity) : that.userEntity != null) return false;
        return !(votetaskSolvetaskEntitySet != null ? !votetaskSolvetaskEntitySet.equals(that.votetaskSolvetaskEntitySet) : that.votetaskSolvetaskEntitySet != null);

    }

    @Override
    public int hashCode() {
        int result1 = (int) (id ^ (id >>> 32));
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (best != null ? best.hashCode() : 0);
        result1 = 31 * result1 + (releaseTime != null ? releaseTime.hashCode() : 0);
        result1 = 31 * result1 + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result1 = 31 * result1 + (completeTime != null ? completeTime.hashCode() : 0);
        result1 = 31 * result1 + (taskEntity != null ? taskEntity.hashCode() : 0);
        result1 = 31 * result1 + (userEntity != null ? userEntity.hashCode() : 0);
        result1 = 31 * result1 + (votetaskSolvetaskEntitySet != null ? votetaskSolvetaskEntitySet.hashCode() : 0);
        return result1;
    }
}
