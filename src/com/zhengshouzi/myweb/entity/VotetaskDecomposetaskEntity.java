package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "votetask_decomposetask")
public class VotetaskDecomposetaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator",strategy = "identity")
    public long id ;

    @ManyToOne
    @JoinColumn(name = "decomposetask_id")
    public DecomposetaskEntity decomposetaskEntity;
    @ManyToOne
    @JoinColumn(name = "votetask_id")
    public VotetaskEntity votetaskEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DecomposetaskEntity getDecomposetaskEntity() {
        return decomposetaskEntity;
    }

    public void setDecomposetaskEntity(DecomposetaskEntity decomposetaskEntity) {
        this.decomposetaskEntity = decomposetaskEntity;
    }

    public VotetaskEntity getVotetaskEntity() {
        return votetaskEntity;
    }

    public void setVotetaskEntity(VotetaskEntity votetaskEntity) {
        this.votetaskEntity = votetaskEntity;
    }
}
