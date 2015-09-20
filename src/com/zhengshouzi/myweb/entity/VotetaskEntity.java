package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "votetask")
public class VotetaskEntity {
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;
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
    @JoinColumn(name = "votetask_id")
    public Set<VotetaskDecomposetaskEntity> votetaskDecomposetaskEntitySet = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "votetask_id")
    public Set<VotetaskSolvetaskEntity> votetaskSolvetaskEntitySet= new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<VotetaskDecomposetaskEntity> getVotetaskDecomposetaskEntitySet() {
        return votetaskDecomposetaskEntitySet;
    }

    public void setVotetaskDecomposetaskEntitySet(Set<VotetaskDecomposetaskEntity> votetaskDecomposetaskEntitySet) {
        this.votetaskDecomposetaskEntitySet = votetaskDecomposetaskEntitySet;
    }

    public Set<VotetaskSolvetaskEntity> getVotetaskSolvetaskEntitySet() {
        return votetaskSolvetaskEntitySet;
    }

    public void setVotetaskSolvetaskEntitySet(Set<VotetaskSolvetaskEntity> votetaskSolvetaskEntitySet) {
        this.votetaskSolvetaskEntitySet = votetaskSolvetaskEntitySet;
    }
}
