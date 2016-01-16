package com.sysu.crowdsourcing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "votetask_solvetask")
public class VotetaskSolvetaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;

    @ManyToOne()
    @JoinColumn(name = "solvetask_id")
    private SolvetaskEntity solvetaskEntity;

    @ManyToOne()
    @JoinColumn(name = "votetask_id")
    private VotetaskEntity votetaskEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SolvetaskEntity getSolvetaskEntity() {
        return solvetaskEntity;
    }

    public void setSolvetaskEntity(SolvetaskEntity solvetaskEntity) {
        this.solvetaskEntity = solvetaskEntity;
    }

    public VotetaskEntity getVotetaskEntity() {
        return votetaskEntity;
    }

    public void setVotetaskEntity(VotetaskEntity votetaskEntity) {
        this.votetaskEntity = votetaskEntity;
    }

    @Override
    public String toString() {
        return "VotetaskSolvetaskEntity{" +
                "id=" + id +
                ", solvetaskEntity=" + solvetaskEntity +
                ", votetaskEntity=" + votetaskEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotetaskSolvetaskEntity that = (VotetaskSolvetaskEntity) o;

        if (id != that.id) return false;
        if (solvetaskEntity != null ? !solvetaskEntity.equals(that.solvetaskEntity) : that.solvetaskEntity != null)
            return false;
        return !(votetaskEntity != null ? !votetaskEntity.equals(that.votetaskEntity) : that.votetaskEntity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (solvetaskEntity != null ? solvetaskEntity.hashCode() : 0);
        result = 31 * result + (votetaskEntity != null ? votetaskEntity.hashCode() : 0);
        return result;
    }
}
