package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "decomposetask")
public class DecomposetaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;
    @Basic
    public Byte step;
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
    public TaskEntity task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user;


    @OneToMany
    @JoinColumn(name = "decomposetask_id")
    public Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet =new HashSet<>();

    @OneToMany
    @JoinColumn(name = "decomposetask_id")
    public Set<VotetaskDecomposetaskEntity> votetaskDecomposetaskEntitySet=new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Byte getStep() {
        return step;
    }

    public void setStep(Byte step) {
        this.step = step;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }


    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
    

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<DecomposetaskTaskEntity> getDecomposetaskTaskEntitySet() {
        return decomposetaskTaskEntitySet;
    }

    public void setDecomposetaskTaskEntitySet(Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet) {
        this.decomposetaskTaskEntitySet = decomposetaskTaskEntitySet;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Set<VotetaskDecomposetaskEntity> getVotetaskDecomposetaskEntitySet() {
        return votetaskDecomposetaskEntitySet;
    }

    public void setVotetaskDecomposetaskEntitySet(Set<VotetaskDecomposetaskEntity> votetaskDecomposetaskEntitySet) {
        this.votetaskDecomposetaskEntitySet = votetaskDecomposetaskEntitySet;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }
}
