package com.zhengshouzi.myweb.entity;

import java.io.Serializable;

/**
 * Created by zhengshouzi on 2015/9/11.
 */
public class VotetaskSolvetaskEntityPK implements Serializable {
    private long voteTaskId;
    private long solveTaskId;

    public long getVoteTaskId() {
        return voteTaskId;
    }

    public void setVoteTaskId(long voteTaskId) {
        this.voteTaskId = voteTaskId;
    }

    public long getSolveTaskId() {
        return solveTaskId;
    }

    public void setSolveTaskId(long solveTaskId) {
        this.solveTaskId = solveTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotetaskSolvetaskEntityPK that = (VotetaskSolvetaskEntityPK) o;

        if (voteTaskId != that.voteTaskId) return false;
        if (solveTaskId != that.solveTaskId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (voteTaskId ^ (voteTaskId >>> 32));
        result = 31 * result + (int) (solveTaskId ^ (solveTaskId >>> 32));
        return result;
    }
}
