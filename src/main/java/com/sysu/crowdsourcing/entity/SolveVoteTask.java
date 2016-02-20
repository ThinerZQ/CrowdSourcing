package com.sysu.crowdsourcing.entity;

import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.entity.WorkflowEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
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
@Table(name = "t_solvevotetask")
public class SolveVoteTask implements WorkflowEntity {


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public SolveTask solveTask = new SolveTask();
    @OneToOne()
    @JoinColumn(name = "userworkitem_id")
    public UserWorkItemEntity userWorkItemEntity;
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
    private long taskId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCompleteTime;

    public UserWorkItemEntity getUserWorkItemEntity() {
        return userWorkItemEntity;
    }

    public void setUserWorkItemEntity(UserWorkItemEntity userWorkItemEntity) {
        this.userWorkItemEntity = userWorkItemEntity;
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

    public SolveTask getSolveTask() {
        return solveTask;
    }

    public void setSolveTask(SolveTask solveTask) {
        this.solveTask = solveTask;
    }

    public Map<String, Object> getNotNullPropertyMap() {
        return null;
    }
}
