package com.zhengshouzi.myweb.forms;

import java.util.Date;

/**
 * Created by ǿ on 2015/9/12.
 */
public class TaskForm {
    public String title;
    public String description;
    public Date deadlineTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

}
