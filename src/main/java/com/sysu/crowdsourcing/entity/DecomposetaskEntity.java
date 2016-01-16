package com.sysu.crowdsourcing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "decomposetask")
public class DecomposetaskEntity implements Serializable {


    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    public long id;
    @Basic
    public Byte step;
    @Basic
    public String best;
    @Basic
    public String price;
    @Temporal(TemporalType.TIMESTAMP)
    public Date releaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date deadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    public Date completeTime;

    @ManyToOne()
    @JoinColumn(name = "task_id")
    public TaskEntity task;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    public UserEntity user;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "decomposetask_id")
    public Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet = new HashSet<DecomposetaskTaskEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "decomposetask_id")
    public Set<VotetaskDecomposetaskEntity> votetaskDecomposetaskEntitySet = new HashSet<VotetaskDecomposetaskEntity>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Byte getStep() {
        return step;
    }

    public void setStep(Byte step) {
        this.step = step;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }


    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }


    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<DecomposetaskTaskEntity> getDecomposetaskTaskEntitySet() {
        return decomposetaskTaskEntitySet;
    }

    public void setDecomposetaskTaskEntitySet(Set<DecomposetaskTaskEntity> decomposetaskTaskEntitySet) {
        this.decomposetaskTaskEntitySet = decomposetaskTaskEntitySet;
    }

    public Set<VotetaskDecomposetaskEntity> getVotetaskDecomposetaskEntitySet() {
        return votetaskDecomposetaskEntitySet;
    }

    public void setVotetaskDecomposetaskEntitySet(Set<VotetaskDecomposetaskEntity> votetaskDecomposetaskEntitySet) {
        this.votetaskDecomposetaskEntitySet = votetaskDecomposetaskEntitySet;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecomposetaskEntity that = (DecomposetaskEntity) o;

        if (id != that.id) return false;
        if (step != null ? !step.equals(that.step) : that.step != null) return false;
        if (best != null ? !best.equals(that.best) : that.best != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (releaseTime != null ? !releaseTime.equals(that.releaseTime) : that.releaseTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (completeTime != null ? !completeTime.equals(that.completeTime) : that.completeTime != null) return false;
        if (task != null ? !task.equals(that.task) : that.task != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (decomposetaskTaskEntitySet != null ? !decomposetaskTaskEntitySet.equals(that.decomposetaskTaskEntitySet) : that.decomposetaskTaskEntitySet != null)
            return false;
        return !(votetaskDecomposetaskEntitySet != null ? !votetaskDecomposetaskEntitySet.equals(that.votetaskDecomposetaskEntitySet) : that.votetaskDecomposetaskEntitySet != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (step != null ? step.hashCode() : 0);
        result = 31 * result + (best != null ? best.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (releaseTime != null ? releaseTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (completeTime != null ? completeTime.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (decomposetaskTaskEntitySet != null ? decomposetaskTaskEntitySet.hashCode() : 0);
        result = 31 * result + (votetaskDecomposetaskEntitySet != null ? votetaskDecomposetaskEntitySet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DecomposetaskEntity{" +
                "id=" + id +
                ", step=" + step +
                ", best='" + best + '\'' +
                ", price='" + price + '\'' +
                ", releaseTime=" + releaseTime +
                ", deadlineTime=" + deadlineTime +
                ", completeTime=" + completeTime +
                ", task=" + task +
                ", user=" + user +
                ", decomposetaskTaskEntitySet=" + decomposetaskTaskEntitySet +
                ", votetaskDecomposetaskEntitySet=" + votetaskDecomposetaskEntitySet +
                '}';
    }
}
