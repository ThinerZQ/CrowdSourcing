package com.zhengshouzi.myweb.entity;

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
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;

    @ManyToOne
    @JoinColumn(name = "solvetask_id")
    private SolvetaskEntity solvetaskEntity;
    @ManyToOne
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
}
