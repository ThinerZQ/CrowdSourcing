package com.zhengshouzi.myweb.entity;

import java.io.Serializable;

/**
 * Created by ǿ on 2015/9/16.
 */
public class DecomposetaskTaskEntityPK implements Serializable {
    private long decomposeTaskId;
    private long taskId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecomposetaskTaskEntityPK that = (DecomposetaskTaskEntityPK) o;

        if (decomposeTaskId != that.decomposeTaskId) return false;
        if (taskId != that.taskId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (decomposeTaskId ^ (decomposeTaskId >>> 32));
        result = 31 * result + (int) (taskId ^ (taskId >>> 32));
        return result;
    }
}
