package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;
    @Basic
    public String title;
    @Temporal(TemporalType.TIMESTAMP)
    public Date releaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date deadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date completeTime;
    @Basic
    public String taskType;
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<DecomposetaskEntity> decomposetaskEntitySet = new HashSet<>();
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet = new HashSet<>();
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<DescriptionEntity> descriptionEntitySet = new HashSet<>();
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<JudgetaskEntity> judgetaskEntitySet = new HashSet<>();
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<MergetaskEntity> mergetaskEntitySet = new HashSet<>();
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<QualificationEntity> qualificationEntitySet = new HashSet<>();
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<SolvetaskEntity> solvetaskEntitySet = new HashSet<>();
    @ManyToOne()
    @JoinColumn(name="task_id")
    public UserEntity userEntity;
    @OneToMany()
    @JoinColumn(name="task_id")
    public Set<VotetaskEntity> votetaskEntitySet = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Set<DecomposetaskEntity> getDecomposetaskEntitySet() {
        return decomposetaskEntitySet;
    }

    public void setDecomposetaskEntitySet(Set<DecomposetaskEntity> decomposetaskEntitySet) {
        this.decomposetaskEntitySet = decomposetaskEntitySet;
    }

    public Set<DecomposetaskTaskEntity> getDecomposetaskTaskEntitySet() {
        return decomposetaskTaskEntitySet;
    }

    public void setDecomposetaskTaskEntitySet(Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet) {
        this.decomposetaskTaskEntitySet = decomposetaskTaskEntitySet;
    }

    public Set<DescriptionEntity> getDescriptionEntitySet() {
        return descriptionEntitySet;
    }

    public void setDescriptionEntitySet(Set<DescriptionEntity> descriptionEntitySet) {
        this.descriptionEntitySet = descriptionEntitySet;
    }

    public Set<JudgetaskEntity> getJudgetaskEntitySet() {
        return judgetaskEntitySet;
    }

    public void setJudgetaskEntitySet(Set<JudgetaskEntity> judgetaskEntitySet) {
        this.judgetaskEntitySet = judgetaskEntitySet;
    }

    public Set<MergetaskEntity> getMergetaskEntitySet() {
        return mergetaskEntitySet;
    }

    public void setMergetaskEntitySet(Set<MergetaskEntity> mergetaskEntitySet) {
        this.mergetaskEntitySet = mergetaskEntitySet;
    }

    public Set<QualificationEntity> getQualificationEntitySet() {
        return qualificationEntitySet;
    }

    public void setQualificationEntitySet(Set<QualificationEntity> qualificationEntitySet) {
        this.qualificationEntitySet = qualificationEntitySet;
    }

    public Set<SolvetaskEntity> getSolvetaskEntitySet() {
        return solvetaskEntitySet;
    }

    public void setSolvetaskEntitySet(Set<SolvetaskEntity> solvetaskEntitySet) {
        this.solvetaskEntitySet = solvetaskEntitySet;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<VotetaskEntity> getVotetaskEntitySet() {
        return votetaskEntitySet;
    }

    public void setVotetaskEntitySet(Set<VotetaskEntity> votetaskEntitySet) {
        this.votetaskEntitySet = votetaskEntitySet;
    }

}
