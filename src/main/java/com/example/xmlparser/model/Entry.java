package com.example.xmlparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "entry", namespace = "http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {
    @XmlElement(name = "title", namespace = "http://www.w3.org/2005/Atom")
    private String title;
    
    @XmlElement(name = "content", namespace = "http://www.w3.org/2005/Atom")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
} 