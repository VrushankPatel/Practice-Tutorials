package com.example.orika.listmapandarraymapping;

import java.util.List;
/*
* Here is a source data class that only has one field, a list of a person's names.
* Let's assume we are very sure that at index 0 there will always be the firstName of
the person and at index 1 there will always be their lastName.
* */

public class PersonNameList {
    private List<String> nameList;

    public PersonNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
