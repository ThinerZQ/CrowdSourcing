package com.zhengshouzi.myweb.entity;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by zhengshouzi on 2015/9/11.
 */
public class VotetaskEntity {
    private long id;
    private Timestamp releaseTime;
    private Timestamp deadlineTime;
    private Timestamp completeTime;
    private Long taskId;
    private Long userId;
    private UserEntity userByUserId;
    private TaskEntity taskByTaskId;
    private Collection<VotetaskDecomposetaskEntity> votetaskDecomposetasksById;
    private Collection<VotetaskSolvetaskEntity> votetaskSolvetasksById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotetaskEntity that = (VotetaskEntity) o;

        if (id != that.id) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;
        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public TaskEntity getTaskByTaskId() {
        return taskByTaskId;
    }

    public void setTaskByTaskId(TaskEntity taskByTaskId) {
        this.taskByTaskId = taskByTaskId;
    }

    public Collection<VotetaskDecomposetaskEntity> getVotetaskDecomposetasksById() {
        return votetaskDecomposetasksById;
    }

    public void setVotetaskDecomposetasksById(Collection<VotetaskDecomposetaskEntity> votetaskDecomposetasksById) {
        this.votetaskDecomposetasksById = votetaskDecomposetasksById;
    }

    public Collection<VotetaskSolvetaskEntity> getVotetaskSolvetasksById() {
        return votetaskSolvetasksById;
    }

    public void setVotetaskSolvetasksById(Collection<VotetaskSolvetaskEntity> votetaskSolvetasksById) {
        this.votetaskSolvetasksById = votetaskSolvetasksById;
    }
}
