package com.zhengshouzi.myweb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name="generator",strategy = "identity")
    public long id;

    @Basic
    public String userName;
    @Basic
    public String password;
    @Basic
    public String email;
    @Basic
    public String activateCode;
    @Basic
    public String status;
    @Temporal(TemporalType.TIMESTAMP)
    public Date registerDate;
    @OneToMany()
    @JoinColumn(name="user_id")
    public Set<DecomposetaskEntity> decomposetaskEntitySet=new HashSet<>();
    @OneToMany()
    @JoinColumn(name="user_id")
    public Set<JudgetaskEntity> judgetaskEntitySet=new HashSet<>();
    @OneToMany()
    @JoinColumn(name="user_id")
    public Set<SolvetaskEntity> solvetaskEntitySet =new HashSet<>();
    @OneToMany()
    @JoinColumn(name="user_id")
    public Set<TaskEntity> taskEntitySet=new HashSet<>();
    @OneToMany()
    @JoinColumn(name="user_id")
    public Set<VotetaskEntity> votetaskEntitySet=new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Set<DecomposetaskEntity> getDecomposetaskEntitySet() {
        return decomposetaskEntitySet;
    }

    public void setDecomposetaskEntitySet(Set<DecomposetaskEntity> decomposetaskEntitySet) {
        this.decomposetaskEntitySet = decomposetaskEntitySet;
    }

    public Set<JudgetaskEntity> getJudgetaskEntitySet() {
        return judgetaskEntitySet;
    }

    public void setJudgetaskEntitySet(Set<JudgetaskEntity> judgetaskEntitySet) {
        this.judgetaskEntitySet = judgetaskEntitySet;
    }

    public Set<SolvetaskEntity> getSolvetaskEntitySet() {
        return solvetaskEntitySet;
    }

    public void setSolvetaskEntitySet(Set<SolvetaskEntity> solvetaskEntitySet) {
        this.solvetaskEntitySet = solvetaskEntitySet;
    }

    public Set<TaskEntity> getTaskEntitySet() {
        return taskEntitySet;
    }

    public void setTaskEntitySet(Set<TaskEntity> taskEntitySet) {
        this.taskEntitySet = taskEntitySet;
    }

    public Set<VotetaskEntity> getVotetaskEntitySet() {
        return votetaskEntitySet;
    }

    public void setVotetaskEntitySet(Set<VotetaskEntity> votetaskEntitySet) {
        this.votetaskEntitySet = votetaskEntitySet;
    }

}
