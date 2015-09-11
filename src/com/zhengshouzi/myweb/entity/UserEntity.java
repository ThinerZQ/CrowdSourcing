package com.zhengshouzi.myweb.entity;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by zhengshouzi on 2015/9/11.
 */
public class UserEntity {
    private long id;
    private String userName;
    private String password;
    private String email;
    private String activateCode;
    private String status;
    private Timestamp registerDate;
    private Collection<DecomposetaskEntity> decomposetasksById;
    private Collection<JudgetaskEntity> judgetasksById;
    private Collection<SolvetaskEntity> solvetasksById;
    private Collection<TaskEntity> tasksById;
    private Collection<VotetaskEntity> votetasksById;

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

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
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

        return true;
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
        return result;
    }

    public Collection<DecomposetaskEntity> getDecomposetasksById() {
        return decomposetasksById;
    }

    public void setDecomposetasksById(Collection<DecomposetaskEntity> decomposetasksById) {
        this.decomposetasksById = decomposetasksById;
    }

    public Collection<JudgetaskEntity> getJudgetasksById() {
        return judgetasksById;
    }

    public void setJudgetasksById(Collection<JudgetaskEntity> judgetasksById) {
        this.judgetasksById = judgetasksById;
    }

    public Collection<SolvetaskEntity> getSolvetasksById() {
        return solvetasksById;
    }

    public void setSolvetasksById(Collection<SolvetaskEntity> solvetasksById) {
        this.solvetasksById = solvetasksById;
    }

    public Collection<TaskEntity> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<TaskEntity> tasksById) {
        this.tasksById = tasksById;
    }

    public Collection<VotetaskEntity> getVotetasksById() {
        return votetasksById;
    }

    public void setVotetasksById(Collection<VotetaskEntity> votetasksById) {
        this.votetasksById = votetasksById;
    }
}
