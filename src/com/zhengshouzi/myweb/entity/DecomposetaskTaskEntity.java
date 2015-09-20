package com.zhengshouzi.myweb.entity;

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
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;
    @Basic
    public  Long whichStep;

    @ManyToOne
    @JoinColumn(name = "decomposetask_id")
    public  DecomposetaskEntity decomposetaskEntity;
    @ManyToOne
    @JoinColumn(name = "task_id")
    public  TaskEntity taskEntity;

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
}
