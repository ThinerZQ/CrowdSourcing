package com.sysu.persistence.model.workflow;

import com.sysu.persistence.model.WorkflowEntity;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/20
 * Time: 19:02
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class FormEntity implements WorkflowEntity {


    private long formId;


    private String formName;


    private String formSrc;


    private UserWorkItemEntity userWorkItemEntity;


    private GroupWorkItemEntity groupWorkItemEntity;

    private Set<FormItemEntity> formItemEntityLinkedHashSet = new LinkedHashSet<FormItemEntity>();


    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormSrc() {
        return formSrc;
    }

    public void setFormSrc(String formSrc) {
        this.formSrc = formSrc;
    }

    public UserWorkItemEntity getUserWorkItemEntity() {
        return userWorkItemEntity;
    }

    public void setUserWorkItemEntity(UserWorkItemEntity userWorkItemEntity) {
        this.userWorkItemEntity = userWorkItemEntity;
    }

    public GroupWorkItemEntity getGroupWorkItemEntity() {
        return groupWorkItemEntity;
    }

    public void setGroupWorkItemEntity(GroupWorkItemEntity groupWorkItemEntity) {
        this.groupWorkItemEntity = groupWorkItemEntity;
    }

    public Set<FormItemEntity> getFormItemEntityLinkedHashSet() {
        return formItemEntityLinkedHashSet;
    }

    public void setFormItemEntityLinkedHashSet(Set<FormItemEntity> formItemEntityLinkedHashSet) {
        this.formItemEntityLinkedHashSet = formItemEntityLinkedHashSet;
    }

    public Map<String, Object> getNotNullPropertyMap() {
        return null;
    }


}
