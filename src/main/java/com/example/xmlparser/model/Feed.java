package com.example.xmlparser.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "feed", namespace = "http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {
    @XmlElement(name = "entry", namespace = "http://www.w3.org/2005/Atom")
    private List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
} 