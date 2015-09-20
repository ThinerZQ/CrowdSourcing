package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "qualification")
public class QualificationEntity {
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;
    @Basic
    public String qualification;

    @ManyToOne()
    @JoinColumn(name = "task_id")
    public TaskEntity taskEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }


    @Override
    public String
    toString() {
        return "QualificationEntity{" +
                "id=" + id +
                ", qualification='" + qualification + '\'' +
                ", taskEntity=" + taskEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QualificationEntity that = (QualificationEntity) o;

        if (id != that.id) return false;
        if (qualification != null ? !qualification.equals(that.qualification) : that.qualification != null)
            return false;
        return !(taskEntity != null ? !taskEntity.equals(that.taskEntity) : that.taskEntity != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        result = 31 * result + (taskEntity != null ? taskEntity.hashCode() : 0);
        return result;
    }
}
