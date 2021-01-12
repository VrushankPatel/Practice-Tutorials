package com.vrushank.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Patient")
public class Patient {
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}