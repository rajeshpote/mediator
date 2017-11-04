
package com.command.mediator.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author RajeshP
 */

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediatorResponseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ContentModel resultset = null;
    private MetadataModel metadata = null;
    private Object[] errors = null;

    public MediatorResponseModel() {

    }

    public MediatorResponseModel(ContentModel resultset, MetadataModel metadata, Object... errors) {
        this.resultset = resultset;
        this.metadata = metadata;
        this.errors = errors;
    }

    public ContentModel getResultset() {
        return resultset;
    }

    public void setResultset(ContentModel content) {
        this.resultset = content;
    }

    public MetadataModel getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataModel metadata) {
        this.metadata = metadata;
    }

    public Object[] getErrors() {
        return errors;
    }

    public void setErrors(Object[] errors) {
        this.errors = errors;
    }
}