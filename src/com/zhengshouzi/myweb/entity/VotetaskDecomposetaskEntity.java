package com.zhengshouzi.myweb.entity;

/**
 * Created by zhengshouzi on 2015/9/11.
 */
public class VotetaskDecomposetaskEntity {
    private long voteTaskId;
    private long decomposeTaskId;
    private DecomposetaskEntity decomposetaskByDecomposeTaskId;
    private VotetaskEntity votetaskByVoteTaskId;

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

        VotetaskDecomposetaskEntity that = (VotetaskDecomposetaskEntity) o;

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

    public DecomposetaskEntity getDecomposetaskByDecomposeTaskId() {
        return decomposetaskByDecomposeTaskId;
    }

    public void setDecomposetaskByDecomposeTaskId(DecomposetaskEntity decomposetaskByDecomposeTaskId) {
        this.decomposetaskByDecomposeTaskId = decomposetaskByDecomposeTaskId;
    }

    public VotetaskEntity getVotetaskByVoteTaskId() {
        return votetaskByVoteTaskId;
    }

    public void setVotetaskByVoteTaskId(VotetaskEntity votetaskByVoteTaskId) {
        this.votetaskByVoteTaskId = votetaskByVoteTaskId;
    }
}
