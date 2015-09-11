package com.zhengshouzi.myweb.entity;

/**
 * Created by zhengshouzi on 2015/9/11.
 */
public class DecomposetaskTaskEntity {
    private long decomposeTaskId;
    private long taskId;
    private Long whichStep;
    private DecomposetaskEntity decomposetaskByDecomposeTaskId;
    private TaskEntity taskByTaskId;

    public long getDecomposeTaskId() {
        return decomposeTaskId;
    }

    public void setDecomposeTaskId(long decomposeTaskId) {
        this.decomposeTaskId = decomposeTaskId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Long getWhichStep() {
        return whichStep;
    }

    public void setWhichStep(Long whichStep) {
        this.whichStep = whichStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecomposetaskTaskEntity that = (DecomposetaskTaskEntity) o;

        if (decomposeTaskId != that.decomposeTaskId) return false;
        if (taskId != that.taskId) return false;
        if (whichStep != null ? !whichStep.equals(that.whichStep) : that.whichStep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (decomposeTaskId ^ (decomposeTaskId >>> 32));
        result = 31 * result + (int) (taskId ^ (taskId >>> 32));
        result = 31 * result + (whichStep != null ? whichStep.hashCode() : 0);
        return result;
    }

    public DecomposetaskEntity getDecomposetaskByDecomposeTaskId() {
        return decomposetaskByDecomposeTaskId;
    }

    public void setDecomposetaskByDecomposeTaskId(DecomposetaskEntity decomposetaskByDecomposeTaskId) {
        this.decomposetaskByDecomposeTaskId = decomposetaskByDecomposeTaskId;
    }

    public TaskEntity getTaskByTaskId() {
        return taskByTaskId;
    }

    public void setTaskByTaskId(TaskEntity taskByTaskId) {
        this.taskByTaskId = taskByTaskId;
    }
}
