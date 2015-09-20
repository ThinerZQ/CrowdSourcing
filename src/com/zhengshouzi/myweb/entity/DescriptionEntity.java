package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "description")
public class DescriptionEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;

    @Basic
    public String description;

    @ManyToOne
    @JoinColumn(name = "task_id")
    public TaskEntity taskEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }


}
