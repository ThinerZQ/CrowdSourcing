package com.zhengshouzi.myweb.entity;

/**
 * Created by ǿ on 2015/9/16.
 */
public class VotetaskSolvetaskEntity {
    private long voteTaskId;
    private long solveTaskId;
    private SolvetaskEntity solvetaskBySolveTaskId;
    private VotetaskEntity votetaskByVoteTaskId;

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

        VotetaskSolvetaskEntity that = (VotetaskSolvetaskEntity) o;

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

    public SolvetaskEntity getSolvetaskBySolveTaskId() {
        return solvetaskBySolveTaskId;
    }

    public void setSolvetaskBySolveTaskId(SolvetaskEntity solvetaskBySolveTaskId) {
        this.solvetaskBySolveTaskId = solvetaskBySolveTaskId;
    }

    public VotetaskEntity getVotetaskByVoteTaskId() {
        return votetaskByVoteTaskId;
    }

    public void setVotetaskByVoteTaskId(VotetaskEntity votetaskByVoteTaskId) {
        this.votetaskByVoteTaskId = votetaskByVoteTaskId;
    }
}
