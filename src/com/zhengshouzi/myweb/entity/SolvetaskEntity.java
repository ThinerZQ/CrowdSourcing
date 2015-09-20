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
    @GenericGenerator(name="generator",strategy = "identity")
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

    @ManyToOne
    @JoinColumn(name = "task_id")
    public TaskEntity taskEntity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity userEntity;
    @OneToMany
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

}
