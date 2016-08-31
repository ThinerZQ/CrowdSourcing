package com.sysu.model.workflow;

import com.sysu.model.WorkflowEntity;
import org.springframework.data.annotation.Id;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/21
 * Time: 15:48
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class FormItemEntity implements WorkflowEntity {

    @Id
    private long formId;


    private String formItemName;
    private String formItemValue;
    private String formItemType;

    private FormEntity formEntity;


    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public String getFormItemName() {
        return formItemName;
    }

    public void setFormItemName(String formItemName) {
        this.formItemName = formItemName;
    }

    public String getFormItemValue() {
        return formItemValue;
    }

    public void setFormItemValue(String formItemValue) {
        this.formItemValue = formItemValue;
    }

    public String getFormItemType() {
        return formItemType;
    }

    public void setFormItemType(String formItemType) {
        this.formItemType = formItemType;
    }

    public FormEntity getFormEntity() {
        return formEntity;
    }

    public void setFormEntity(FormEntity formEntity) {
        this.formEntity = formEntity;
    }

    public Map<String, Object> getNotNullPropertyMap() {
        return null;
    }
}
