package com.sysu.persistence.model.crowdsourcing;


import com.sysu.persistence.model.WorkflowEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhengshouzi on 2015/9/17.
 */
public class CrowdSourcingTaskEntity implements WorkflowEntity {

    private long taskId;

    private String taskName;

    private String taskDescription;


    private Date taskDeadlineTime;

    private Date taskCompleteTime;

    private String taskType;

    private String taskPrice;

    private String taskSolution;

    private int taskJudgeCount = 3;

    private int taskDecomposeCount = 2;

    private int taskDecomposeVoteCount = 3;

    private int taskSolveCount = 2;

    private int taskSolveVoteCount = 3;

    private int taskStep = 3;

    public void updateTaskType(String taskType) {

    }

    public void saveSelf() {


    }

    public void getBestDecomposeTask() {

    }

   /* public boolean merge() {


        // CrowdSourcingTaskEntity crowdSourcingTask   = Tasktt.getSubCrowdSourcingTask(this.getTaskId());
        // Set<CrowdSourcingTaskEntity> subCrowdSourcingSet  = crowdSourcingTask.getTaskSubCrowdSourcingTask();
        // merge

        // can this is right ? ?

        Set<CrowdSourcingTaskEntity> tempCrowdSourcingTaks = this.getTaskSubCrowdSourcingTask();
        ArrayList<CrowdSourcingTaskEntity> subCrowdSourcingTaskArrayList = new ArrayList<CrowdSourcingTaskEntity>();
        for (CrowdSourcingTaskEntity crowdSourcingTask : tempCrowdSourcingTaks) {
            try {
                Connection connection = DBHelper.getMySqlConnection();
                String sql = "select * from t_crowdsourcingtask where taskId=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setLong(1, crowdSourcingTask.getTaskId());

                ResultSet resultSet = preparedStatement.executeQuery();
                CrowdSourcingTaskEntity solvedCrowdSourcingTask = new CrowdSourcingTaskEntity();
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

        Collections.sort(subCrowdSourcingTaskArrayList, new Comparator<CrowdSourcingTaskEntity>() {
            public int compare(CrowdSourcingTaskEntity o1, CrowdSourcingTaskEntity o2) {
                if (o1.getTaskStep() > o2.getTaskStep())
                    return 1;
                return 0;
            }
        });

        StringBuilder taskSolutions = new StringBuilder();
        for (CrowdSourcingTaskEntity temp : subCrowdSourcingTaskArrayList) {
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
    }*/

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



    public Map<String, Object> getNotNullPropertyMap() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getTaskName() != null) {
            map.put("taskName", getTaskName());
        }

        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;

    }
}

