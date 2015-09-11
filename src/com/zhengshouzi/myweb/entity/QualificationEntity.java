package com.zhengshouzi.myweb.entity;

/**
 * Created by zhengshouzi on 2015/9/11.
 */
public class QualificationEntity {
    private long id;
    private String qualification;
    private Long taskId;
    private TaskEntity taskByTaskId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QualificationEntity that = (QualificationEntity) o;

        if (id != that.id) return false;
        if (qualification != null ? !qualification.equals(that.qualification) : that.qualification != null)
            return false;
        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        return result;
    }

    public TaskEntity getTaskByTaskId() {
        return taskByTaskId;
    }

    public void setTaskByTaskId(TaskEntity taskByTaskId) {
        this.taskByTaskId = taskByTaskId;
    }
}
