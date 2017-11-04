
package com.command.mediator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContentModel implements Serializable {

    private List content = null;

    public ContentModel() {
        this.content = new ArrayList();
    }

    public List getContent() {
        return content;
    }

    public void setContent(Object content) {
        if (content instanceof List) {
            this.content = (List) content;
        } else {
            this.content.add(content);
        }
    }

}
