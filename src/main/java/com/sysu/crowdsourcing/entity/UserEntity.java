package com.sysu.crowdsourcing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
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
    @GenericGenerator(name = "generator", strategy = "identity")
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<DecomposetaskEntity> decomposetaskEntitySet = new HashSet<DecomposetaskEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<JudgetaskEntity> judgetaskEntitySet = new HashSet<JudgetaskEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<SolvetaskEntity> solvetaskEntitySet = new HashSet<SolvetaskEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<TaskEntity> taskEntitySet = new HashSet<TaskEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<VotetaskEntity> votetaskEntitySet = new HashSet<VotetaskEntity>();


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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", activateCode='" + activateCode + '\'' +
                ", status='" + status + '\'' +
                ", registerDate=" + registerDate +
                ", decomposetaskEntitySet=" + decomposetaskEntitySet +
                ", judgetaskEntitySet=" + judgetaskEntitySet +
                ", solvetaskEntitySet=" + solvetaskEntitySet +
                ", taskEntitySet=" + taskEntitySet +
                ", votetaskEntitySet=" + votetaskEntitySet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (activateCode != null ? !activateCode.equals(that.activateCode) : that.activateCode != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (decomposetaskEntitySet != null ? !decomposetaskEntitySet.equals(that.decomposetaskEntitySet) : that.decomposetaskEntitySet != null)
            return false;
        if (judgetaskEntitySet != null ? !judgetaskEntitySet.equals(that.judgetaskEntitySet) : that.judgetaskEntitySet != null)
            return false;
        if (solvetaskEntitySet != null ? !solvetaskEntitySet.equals(that.solvetaskEntitySet) : that.solvetaskEntitySet != null)
            return false;
        if (taskEntitySet != null ? !taskEntitySet.equals(that.taskEntitySet) : that.taskEntitySet != null)
            return false;
        return !(votetaskEntitySet != null ? !votetaskEntitySet.equals(that.votetaskEntitySet) : that.votetaskEntitySet != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (activateCode != null ? activateCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (decomposetaskEntitySet != null ? decomposetaskEntitySet.hashCode() : 0);
        result = 31 * result + (judgetaskEntitySet != null ? judgetaskEntitySet.hashCode() : 0);
        result = 31 * result + (solvetaskEntitySet != null ? solvetaskEntitySet.hashCode() : 0);
        result = 31 * result + (taskEntitySet != null ? taskEntitySet.hashCode() : 0);
        result = 31 * result + (votetaskEntitySet != null ? votetaskEntitySet.hashCode() : 0);
        return result;
    }
}
