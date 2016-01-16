package com.sysu.crowdsourcing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "decomposetask_task")
public class DecomposetaskTaskEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;
    @Basic
    public Long whichStep;

    @ManyToOne()
    @JoinColumn(name = "decomposetask_id")
    public DecomposetaskEntity decomposetaskEntity;
    @ManyToOne()
    @JoinColumn(name = "task_id")
    public TaskEntity taskEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getWhichStep() {
        return whichStep;
    }

    public void setWhichStep(Long whichStep) {
        this.whichStep = whichStep;
    }

    public DecomposetaskEntity getDecomposetaskEntity() {
        return decomposetaskEntity;
    }

    public void setDecomposetaskEntity(DecomposetaskEntity decomposetaskEntity) {
        this.decomposetaskEntity = decomposetaskEntity;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    @Override
    public String toString() {
        return "DecomposetaskTaskEntity{" +
                "id=" + id +
                ", whichStep=" + whichStep +
                ", decomposetaskEntity=" + decomposetaskEntity +
                ", taskEntity=" + taskEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecomposetaskTaskEntity that = (DecomposetaskTaskEntity) o;

        if (id != that.id) return false;
        if (whichStep != null ? !whichStep.equals(that.whichStep) : that.whichStep != null) return false;
        if (decomposetaskEntity != null ? !decomposetaskEntity.equals(that.decomposetaskEntity) : that.decomposetaskEntity != null)
            return false;
        return !(taskEntity != null ? !taskEntity.equals(that.taskEntity) : that.taskEntity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (whichStep != null ? whichStep.hashCode() : 0);
        result = 31 * result + (decomposetaskEntity != null ? decomposetaskEntity.hashCode() : 0);
        result = 31 * result + (taskEntity != null ? taskEntity.hashCode() : 0);
        return result;
    }
}
