package com.zhengshouzi.myweb.beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class Task {
    private int id;
    private String title;
    private Timestamp releaseTime;
    private  Timestamp deadlineTime;
    private Timestamp completeTime;
    private Map<Integer,Description> descriptionMap;
    private Map<Integer,Qualification> qualificationMap;


    public Map<Integer, Description> getDescriptionMap() {
        return descriptionMap;
    }

    public void setDescriptionMap(Map<Integer, Description> descriptionMap) {
        this.descriptionMap = descriptionMap;
    }

    public Map<Integer, Qualification> getQualificationMap() {
        return qualificationMap;
    }

    public void setQualificationMap(Map<Integer, Qualification> qualificationMap) {
        this.qualificationMap = qualificationMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Timestamp getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Timestamp deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public Timestamp getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseTime=" + releaseTime +
                ", deadlineTime=" + deadlineTime +
                ", completeTime=" + completeTime +
                ", descriptionMap=" + descriptionMap +
                ", qualificationMap=" + qualificationMap +
                '}';
    }
}
