package com.zhengshouzi.myweb.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by ǿ on 2015/9/16.
 */
public class TaskEntity {
    private long id;
    private String title;
    private Timestamp releaseTime;
    private Timestamp deadlineTime;
    private Timestamp completeTime;
    private String taskType;
    private Collection<DecomposetaskEntity> decomposetasksById;
    private Collection<DecomposetaskTaskEntity> decomposetaskTasksById;
    private Collection<DescriptionEntity> descriptionsById = new HashSet<>();
    private Collection<JudgetaskEntity> judgetasksById;
    private Collection<MergetaskEntity> mergetasksById;
    private Collection<QualificationEntity> qualificationsById;
    private Collection<SolvetaskEntity> solvetasksById;
    private UserEntity userByUserId;
    private Collection<VotetaskEntity> votetasksById;

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

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Timestamp getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Timestamp deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public Timestamp getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        return result;
    }

    public Collection<DecomposetaskEntity> getDecomposetasksById() {
        return decomposetasksById;
    }

    public void setDecomposetasksById(Collection<DecomposetaskEntity> decomposetasksById) {
        this.decomposetasksById = decomposetasksById;
    }

    public Collection<DecomposetaskTaskEntity> getDecomposetaskTasksById() {
        return decomposetaskTasksById;
    }

    public void setDecomposetaskTasksById(Collection<DecomposetaskTaskEntity> decomposetaskTasksById) {
        this.decomposetaskTasksById = decomposetaskTasksById;
    }

    public Collection<DescriptionEntity> getDescriptionsById() {
        return descriptionsById;
    }

    public void setDescriptionsById(Collection<DescriptionEntity> descriptionsById) {
        this.descriptionsById = descriptionsById;
    }

    public Collection<JudgetaskEntity> getJudgetasksById() {
        return judgetasksById;
    }

    public void setJudgetasksById(Collection<JudgetaskEntity> judgetasksById) {
        this.judgetasksById = judgetasksById;
    }

    public Collection<MergetaskEntity> getMergetasksById() {
        return mergetasksById;
    }

    public void setMergetasksById(Collection<MergetaskEntity> mergetasksById) {
        this.mergetasksById = mergetasksById;
    }

    public Collection<QualificationEntity> getQualificationsById() {
        return qualificationsById;
    }

    public void setQualificationsById(Collection<QualificationEntity> qualificationsById) {
        this.qualificationsById = qualificationsById;
    }

    public Collection<SolvetaskEntity> getSolvetasksById() {
        return solvetasksById;
    }

    public void setSolvetasksById(Collection<SolvetaskEntity> solvetasksById) {
        this.solvetasksById = solvetasksById;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Collection<VotetaskEntity> getVotetasksById() {
        return votetasksById;
    }

    public void setVotetasksById(Collection<VotetaskEntity> votetasksById) {
        this.votetasksById = votetasksById;
    }
}
