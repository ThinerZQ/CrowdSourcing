package com.sysu.persistence.model.crowdsourcing;

import com.sysu.persistence.model.WorkflowEntity;

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

public class SolveVoteTaskEntity implements WorkflowEntity {


    private long id;

    @Override
    public Map<String, Object> getNotNullPropertyMap() {
        return null;
    }




    /*public Map<String, Object> getNotNullPropertyMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentObject", this.getClass().getName());
        if (getTaskId() != 0) {
            map.put("taskId", getTaskId());
        }
        if (getSolveTask() != null) {
            map.put("solveTask", getSolveTask());
        }
        if (getUserWorkItemEntity() != null) {
            map.put("userWorkItemEntity", getUserWorkItemEntity());
        }
        System.out.println("Query Condition: " + map);
        map.remove("currentObject");
        return map;
    }*/


}
