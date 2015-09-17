package com.zhengshouzi.myweb.entity;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by ǿ on 2015/9/16.
 */
public class DecomposetaskEntity {
    private long id;
    private Byte step;
    private String best;
    private Timestamp releaseTime;
    private Timestamp deadlineTime;
    private Timestamp completeTime;
    private TaskEntity taskByTaskId;
    private UserEntity userByUserId;
    private Collection<DecomposetaskTaskEntity> decomposetaskTasksById;
    private Collection<VotetaskDecomposetaskEntity> votetaskDecomposetasksById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecomposetaskEntity that = (DecomposetaskEntity) o;

        if (id != that.id) return false;
        if (step != null ? !step.equals(that.step) : that.step != null) return false;
        if (best != null ? !best.equals(that.best) : that.best != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (step != null ? step.hashCode() : 0);
        result = 31 * result + (best != null ? best.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        return result;
    }

    public TaskEntity getTaskByTaskId() {
        return taskByTaskId;
    }

    public void setTaskByTaskId(TaskEntity taskByTaskId) {
        this.taskByTaskId = taskByTaskId;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Collection<DecomposetaskTaskEntity> getDecomposetaskTasksById() {
        return decomposetaskTasksById;
    }

    public void setDecomposetaskTasksById(Collection<DecomposetaskTaskEntity> decomposetaskTasksById) {
        this.decomposetaskTasksById = decomposetaskTasksById;
    }

    public Collection<VotetaskDecomposetaskEntity> getVotetaskDecomposetasksById() {
        return votetaskDecomposetasksById;
    }

    public void setVotetaskDecomposetasksById(Collection<VotetaskDecomposetaskEntity> votetaskDecomposetasksById) {
        this.votetaskDecomposetasksById = votetaskDecomposetasksById;
    }
}
