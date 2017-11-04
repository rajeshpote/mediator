
package com.command.mediator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Rajesh
 */
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceError {

    private int code;
    private String message = null;
    @XmlElement(name = "field_name")
    private String fieldName = null;

    public ServiceError() {
    }

    public ServiceError(String message, int code, String fieldName) {
        this.message = message;
        this.fieldName = fieldName;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}