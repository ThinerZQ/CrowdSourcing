package com.sysu.model.crowdsourcing;

import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.entity.WorkflowEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/19
 * Time: 15:28
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

@Entity
@Table(name = "t_solvetask")
public class SolveTask implements WorkflowEntity {


    @OneToOne()
    @JoinColumn(name = "solvevotetask_id")
    public SolveVoteTask solveVoteTask;
    @OneToOne()
    @JoinColumn(name = "userworkitem_id")
    public UserWorkItemEntity userWorkItemEntity;
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    private long taskId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCompleteTime;
    @Column(length = 65000)
    private String taskSolution;
    @Basic
    private String taskBest;

    public UserWorkItemEntity getUserWorkItemEntity() {
        return userWorkItemEntity;
    }

    public void setUserWorkItemEntity(UserWorkItemEntity userWorkItemEntity) {
        this.userWorkItemEntity = userWorkItemEntity;
    }

    @Override
    public String toString() {
        return "SolveTask{" +
                "taskId=" + taskId +
                ", taskCompleteTime=" + taskCompleteTime +
                ", taskSolution='" + taskSolution + '\'' +
                ", taskBest='" + taskBest + '\'' +
                ", solveVoteTask=" + solveVoteTask +
                ", userWorkItemEntity=" + userWorkItemEntity +
                '}';
    }

    public String getTaskBest() {
        return taskBest;
    }

    public void setTaskBest(String taskBest) {
        this.taskBest = taskBest;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }

    public String getTaskSolution() {
        return taskSolution;
    }

    public void setTaskSolution(String taskSolution) {
        this.taskSolution = taskSolution;
    }

    public SolveVoteTask getSolveVoteTask() {
        return solveVoteTask;
    }

    public void setSolveVoteTask(SolveVoteTask solveVoteTask) {
        this.solveVoteTask = solveVoteTask;
    }


    public Map<String, Object> getNotNullPropertyMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getTaskSolution() != null) {
            map.put("taskSolution", getTaskSolution());
        }
        if (getUserWorkItemEntity() != null) {
            map.put("userWorkItemEntity", getUserWorkItemEntity());
        }
        if (getSolveVoteTask() != null) {
            map.put("solveVoteTask", getSolveVoteTask());
        }
        if (getTaskBest() != null) {
            map.put("taskBest", getTaskBest());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;
    }

}
