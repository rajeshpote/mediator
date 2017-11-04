package com.command.mediator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author RajeshP
 */

@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Boolean success = Boolean.FALSE;
    private Integer count = null;
    @XmlElement(name = "request_time")
    private String requestTime = null;
    @XmlElement(name = "request_params")
    private String requestParams = null;
    @XmlElement(name = "request_id")
    private String requestId = null;

    public MetadataModel() {
    }

    public MetadataModel(Boolean success, String requestId, String requestParams, String requestTime, Integer count) {
        this.success = success;
        this.requestId = requestId;
        this.requestParams = requestParams;
        this.requestTime = requestTime;
        this.count = count;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestProcessingTime(long requestStartTime) {
        return (System.currentTimeMillis() - requestStartTime) / 1000.0f + " seconds";
    }

}
