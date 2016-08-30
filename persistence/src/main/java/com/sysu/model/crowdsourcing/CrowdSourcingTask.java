package com.sysu.model.crowdsourcing;


import com.sysu.model.crowdsourcing.tools.DBHelper;
import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.entity.WorkflowEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


/**
 * Created by zhengshouzi on 2015/9/17.
 */
@Entity
@Table(name = "t_crowdsourcingtask")
public class CrowdSourcingTask implements WorkflowEntity {


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
    @Column(length = 65000)
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
    @Basic
    private int taskStep = 3;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "processInstanceId")
    private ProcessInstanceEntity processInstanceEntity;
    @OneToMany(targetEntity = CrowdSourcingTask.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("taskStep")
    private Set<CrowdSourcingTask> taskSubCrowdSourcingTask;

    @ManyToOne
    private CrowdSourcingTask taskParentCrowdSourcingTask;

    public void updateTaskType(String taskType) {

    }

    public void saveSelf() {


    }

    public void getBestDecomposeTask() {

    }

    public boolean merge() {


        // CrowdSourcingTask crowdSourcingTask   = Tasktt.getSubCrowdSourcingTask(this.getTaskId());
        // Set<CrowdSourcingTask> subCrowdSourcingSet  = crowdSourcingTask.getTaskSubCrowdSourcingTask();
        // merge

        // can this is right ? ?

        Set<CrowdSourcingTask> tempCrowdSourcingTaks = this.getTaskSubCrowdSourcingTask();
        ArrayList<CrowdSourcingTask> subCrowdSourcingTaskArrayList = new ArrayList<CrowdSourcingTask>();
        for (CrowdSourcingTask crowdSourcingTask : tempCrowdSourcingTaks) {
            try {
                Connection connection = DBHelper.getMySqlConnection();
                String sql = "select * from t_crowdsourcingtask where taskId=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setLong(1, crowdSourcingTask.getTaskId());

                ResultSet resultSet = preparedStatement.executeQuery();
                CrowdSourcingTask solvedCrowdSourcingTask = new CrowdSourcingTask();
                while (resultSet.next()) {
                    solvedCrowdSourcingTask.setTaskId(resultSet.getLong("taskId"));
                    solvedCrowdSourcingTask.setTaskStep(resultSet.getInt("taskStep"));
                    solvedCrowdSourcingTask.setTaskSolution(resultSet.getString("taskSolution"));
                }
                subCrowdSourcingTaskArrayList.add(solvedCrowdSourcingTask);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Collections.sort(subCrowdSourcingTaskArrayList, new Comparator<CrowdSourcingTask>() {
            public int compare(CrowdSourcingTask o1, CrowdSourcingTask o2) {
                if (o1.getTaskStep() > o2.getTaskStep())
                    return 1;
                return 0;
            }
        });

        StringBuilder taskSolutions = new StringBuilder();
        for (CrowdSourcingTask temp : subCrowdSourcingTaskArrayList) {
            taskSolutions.append(temp.getTaskSolution());
            taskSolutions.append("</br>");
        }
        taskSolutions.delete(taskSolutions.lastIndexOf("</br>"), taskSolutions.length() - 1);
        this.setTaskSolution(taskSolutions.toString());

        // update this task ;
        try {
            Connection connection = DBHelper.getMySqlConnection();
            String sql = "update t_crowdsourcingtask SET taskSolution= ? WHERE taskId=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, this.getTaskSolution());
            preparedStatement.setLong(2, this.getTaskId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(String taskPrice) {
        this.taskPrice = taskPrice;
    }

    public String getTaskSolution() {
        return taskSolution;
    }

    public void setTaskSolution(String taskSolution) {
        this.taskSolution = taskSolution;
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

    public int getTaskStep() {
        return taskStep;
    }

    public void setTaskStep(int taskStep) {
        this.taskStep = taskStep;
    }

    public ProcessInstanceEntity getProcessInstanceEntity() {
        return processInstanceEntity;
    }

    public void setProcessInstanceEntity(ProcessInstanceEntity processInstanceEntity) {
        this.processInstanceEntity = processInstanceEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<CrowdSourcingTask> getTaskSubCrowdSourcingTask() {
        return taskSubCrowdSourcingTask;
    }

    public void setTaskSubCrowdSourcingTask(Set<CrowdSourcingTask> taskSubCrowdSourcingTask) {
        this.taskSubCrowdSourcingTask = taskSubCrowdSourcingTask;
    }

    public CrowdSourcingTask getTaskParentCrowdSourcingTask() {
        return taskParentCrowdSourcingTask;
    }

    public void setTaskParentCrowdSourcingTask(CrowdSourcingTask taskParentCrowdSourcingTask) {
        this.taskParentCrowdSourcingTask = taskParentCrowdSourcingTask;
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
                ", taskStep=" + taskStep +
                ", processInstanceEntity=" + processInstanceEntity +
                ", taskSubCrowdSourcingTask=" + taskSubCrowdSourcingTask +
                ", taskParentCrowdSourcingTask=" + taskParentCrowdSourcingTask +
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
        if (getUserEntity() != null) {
            map.put("userEntity", getUserEntity());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;

    }
}

