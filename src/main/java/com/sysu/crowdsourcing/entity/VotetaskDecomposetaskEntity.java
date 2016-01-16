package com.sysu.crowdsourcing.entity;

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
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;

    @ManyToOne()
    @JoinColumn(name = "decomposetask_id")
    public DecomposetaskEntity decomposetaskEntity;

    @ManyToOne()
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

    @Override
    public String toString() {
        return "VotetaskDecomposetaskEntity{" +
                "id=" + id +
                ", decomposetaskEntity=" + decomposetaskEntity +
                ", votetaskEntity=" + votetaskEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotetaskDecomposetaskEntity that = (VotetaskDecomposetaskEntity) o;

        if (id != that.id) return false;
        if (decomposetaskEntity != null ? !decomposetaskEntity.equals(that.decomposetaskEntity) : that.decomposetaskEntity != null)
            return false;
        return !(votetaskEntity != null ? !votetaskEntity.equals(that.votetaskEntity) : that.votetaskEntity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (decomposetaskEntity != null ? decomposetaskEntity.hashCode() : 0);
        result = 31 * result + (votetaskEntity != null ? votetaskEntity.hashCode() : 0);
        return result;
    }
}
