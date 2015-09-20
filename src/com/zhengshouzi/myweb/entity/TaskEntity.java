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
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
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

    @Basic
    public String price;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    public UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public Set<DecomposetaskEntity> decomposetaskEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    public Set<DescriptionEntity> descriptionEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public Set<JudgetaskEntity> judgetaskEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public Set<MergetaskEntity> mergetaskEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public Set<QualificationEntity> qualificationEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    public Set<SolvetaskEntity> solvetaskEntitySet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (decomposetaskEntitySet != null ? decomposetaskEntitySet.hashCode() : 0);
        result = 31 * result + (decomposetaskTaskEntitySet != null ? decomposetaskTaskEntitySet.hashCode() : 0);
        result = 31 * result + (descriptionEntitySet != null ? descriptionEntitySet.hashCode() : 0);
        result = 31 * result + (judgetaskEntitySet != null ? judgetaskEntitySet.hashCode() : 0);
        result = 31 * result + (mergetaskEntitySet != null ? mergetaskEntitySet.hashCode() : 0);
        result = 31 * result + (qualificationEntitySet != null ? qualificationEntitySet.hashCode() : 0);
        result = 31 * result + (solvetaskEntitySet != null ? solvetaskEntitySet.hashCode() : 0);
        result = 31 * result + (userEntity != null ? userEntity.hashCode() : 0);
        result = 31 * result + (votetaskEntitySet != null ? votetaskEntitySet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseTime=" + releaseTime +
                ", deadlineTime=" + deadlineTime +
                ", completeTime=" + completeTime +
                ", taskType='" + taskType + '\'' +
                ", price='" + price + '\'' +
                ", decomposetaskEntitySet=" + decomposetaskEntitySet +
                ", decomposetaskTaskEntitySet=" + decomposetaskTaskEntitySet +
                ", descriptionEntitySet=" + descriptionEntitySet +
                ", judgetaskEntitySet=" + judgetaskEntitySet +
                ", mergetaskEntitySet=" + mergetaskEntitySet +
                ", qualificationEntitySet=" + qualificationEntitySet +
                ", solvetaskEntitySet=" + solvetaskEntitySet +
                ", userEntity=" + userEntity +
                ", votetaskEntitySet=" + votetaskEntitySet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;
        if (taskType != null ? !taskType.equals(that.taskType) : that.taskType != null) return false;
        if (decomposetaskEntitySet != null ? !decomposetaskEntitySet.equals(that.decomposetaskEntitySet) : that.decomposetaskEntitySet != null)
            return false;
        if (decomposetaskTaskEntitySet != null ? !decomposetaskTaskEntitySet.equals(that.decomposetaskTaskEntitySet) : that.decomposetaskTaskEntitySet != null)
            return false;
        if (descriptionEntitySet != null ? !descriptionEntitySet.equals(that.descriptionEntitySet) : that.descriptionEntitySet != null)
            return false;
        if (judgetaskEntitySet != null ? !judgetaskEntitySet.equals(that.judgetaskEntitySet) : that.judgetaskEntitySet != null)
            return false;
        if (mergetaskEntitySet != null ? !mergetaskEntitySet.equals(that.mergetaskEntitySet) : that.mergetaskEntitySet != null)
            return false;
        if (qualificationEntitySet != null ? !qualificationEntitySet.equals(that.qualificationEntitySet) : that.qualificationEntitySet != null)
            return false;
        if (solvetaskEntitySet != null ? !solvetaskEntitySet.equals(that.solvetaskEntitySet) : that.solvetaskEntitySet != null)
            return false;
        if (userEntity != null ? !userEntity.equals(that.userEntity) : that.userEntity != null) return false;
        return !(votetaskEntitySet != null ? !votetaskEntitySet.equals(that.votetaskEntitySet) : that.votetaskEntitySet != null);

    }

}
