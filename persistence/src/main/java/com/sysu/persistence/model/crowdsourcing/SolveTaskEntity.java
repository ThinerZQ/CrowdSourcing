package com.sysu.persistence.model.crowdsourcing;


import com.sysu.persistence.model.WorkflowEntity;

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


public class SolveTaskEntity implements WorkflowEntity {


    private long taskId;
    private Date taskCompleteTime;
    private String taskSolution;
    private String taskBest;



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


    public Map<String, Object> getNotNullPropertyMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getTaskSolution() != null) {
            map.put("taskSolution", getTaskSolution());
        }
        if (getTaskBest() != null) {
            map.put("taskBest", getTaskBest());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;
    }

}
