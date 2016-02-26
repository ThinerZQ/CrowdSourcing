package com.sysu.crowdsourcing.entity;


import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.entity.WorkflowEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;


/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "t_crowdsourcingtask")
public class CrowdSourcingTask implements WorkflowEntity {


    @ManyToOne()
    @JoinColumn(name = "user_id")
    public UserEntity userEntity;
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    private long taskId;
    @Basic
    private String taskName;
    @Basic
    private String taskDescription;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskReleaseTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskDeadlineTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCompleteTime;
    @Basic
    private String taskType;
    @Basic
    private String taskPrice;
    @Basic
    private String taskSolution;
    @Basic
    private int taskJudgeCount = 3;
    @Basic
    private int taskDecomposeCount = 2;
    @Basic
    private int taskDecomposeVoteCount = 3;
    @Basic
    private int taskSolveCount = 2;
    @Basic
    private int taskSolveVoteCount = 3;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "processInstanceId")
    private ProcessInstanceEntity processInstanceEntity;


    @OneToMany
    private Set<CrowdSourcingTask> taskSubCrowdSourcingTask = new HashSet<CrowdSourcingTask>();


    public void updateTaskType(String taskType) {


    }

    public void saveSelf() {


    }

    public void getBestDecomposeTask() {

    }

    public void merge() {


        // CrowdSourcingTask crowdSourcingTask   = Tasktt.getSubCrowdSourcingTask(this.getTaskId());
        //Set<CrowdSourcingTask> subCrowdSourcingSet  = crowdSourcingTask.getTaskSubCrowdSourcingTask();
        // merge

        // can this is right ? ?


    }

    public String getTaskSolution() {
        return taskSolution;
    }

    public void setTaskSolution(String taskSolution) {
        this.taskSolution = taskSolution;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getTaskReleaseTime() {
        return taskReleaseTime;
    }

    public void setTaskReleaseTime(Date taskReleaseTime) {
        this.taskReleaseTime = taskReleaseTime;
    }

    public Date getTaskDeadlineTime() {
        return taskDeadlineTime;
    }

    public void setTaskDeadlineTime(Date taskDeadlineTime) {
        this.taskDeadlineTime = taskDeadlineTime;
    }

    public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }

    public String getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(String taskPrice) {
        this.taskPrice = taskPrice;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getTaskJudgeCount() {
        return taskJudgeCount;
    }

    public void setTaskJudgeCount(int taskJudgeCount) {
        this.taskJudgeCount = taskJudgeCount;
    }

    public int getTaskDecomposeCount() {
        return taskDecomposeCount;
    }

    public void setTaskDecomposeCount(int taskDecomposeCount) {
        this.taskDecomposeCount = taskDecomposeCount;
    }

    public int getTaskDecomposeVoteCount() {
        return taskDecomposeVoteCount;
    }

    public void setTaskDecomposeVoteCount(int taskDecomposeVoteCount) {
        this.taskDecomposeVoteCount = taskDecomposeVoteCount;
    }

    public ProcessInstanceEntity getProcessInstanceEntity() {
        return processInstanceEntity;
    }

    public void setProcessInstanceEntity(ProcessInstanceEntity processInstanceEntity) {
        this.processInstanceEntity = processInstanceEntity;
    }

    public int getTaskSolveCount() {
        return taskSolveCount;
    }

    public void setTaskSolveCount(int taskSolveCount) {
        this.taskSolveCount = taskSolveCount;
    }

    public int getTaskSolveVoteCount() {
        return taskSolveVoteCount;
    }

    public void setTaskSolveVoteCount(int taskSolveVoteCount) {
        this.taskSolveVoteCount = taskSolveVoteCount;
    }


    public Set<CrowdSourcingTask> getTaskSubCrowdSourcingTask() {
        return taskSubCrowdSourcingTask;
    }

    public void setTaskSubCrowdSourcingTask(Set<CrowdSourcingTask> taskSubCrowdSourcingTask) {
        this.taskSubCrowdSourcingTask = taskSubCrowdSourcingTask;
    }

    @Override
    public String toString() {
        return "CrowdSourcingTask{" +
                "userEntity=" + userEntity +
                ", taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskReleaseTime=" + taskReleaseTime +
                ", taskDeadlineTime=" + taskDeadlineTime +
                ", taskCompleteTime=" + taskCompleteTime +
                ", taskType='" + taskType + '\'' +
                ", taskPrice='" + taskPrice + '\'' +
                ", taskSolution='" + taskSolution + '\'' +
                ", taskJudgeCount=" + taskJudgeCount +
                ", taskDecomposeCount=" + taskDecomposeCount +
                ", taskDecomposeVoteCount=" + taskDecomposeVoteCount +
                ", taskSolveCount=" + taskSolveCount +
                ", taskSolveVoteCount=" + taskSolveVoteCount +
                ", processInstanceEntity=" + processInstanceEntity +
                '}';
    }

    public Map<String, Object> getNotNullPropertyMap() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getTaskName() != null) {
            map.put("taskName", getTaskName());
        }
        if (getProcessInstanceEntity() != null) {
            map.put("processInstanceEntity", getProcessInstanceEntity());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;

    }
}

