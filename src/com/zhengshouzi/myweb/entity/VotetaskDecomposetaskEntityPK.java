package com.zhengshouzi.myweb.entity;

import java.io.Serializable;

/**
 * Created by ǿ on 2015/9/16.
 */
public class VotetaskDecomposetaskEntityPK implements Serializable {
    private long voteTaskId;
    private long decomposeTaskId;

    public long getVoteTaskId() {
        return voteTaskId;
    }

    public void setVoteTaskId(long voteTaskId) {
        this.voteTaskId = voteTaskId;
    }

    public long getDecomposeTaskId() {
        return decomposeTaskId;
    }

    public void setDecomposeTaskId(long decomposeTaskId) {
        this.decomposeTaskId = decomposeTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotetaskDecomposetaskEntityPK that = (VotetaskDecomposetaskEntityPK) o;

        if (voteTaskId != that.voteTaskId) return false;
        if (decomposeTaskId != that.decomposeTaskId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (voteTaskId ^ (voteTaskId >>> 32));
        result = 31 * result + (int) (decomposeTaskId ^ (decomposeTaskId >>> 32));
        return result;
    }
}
