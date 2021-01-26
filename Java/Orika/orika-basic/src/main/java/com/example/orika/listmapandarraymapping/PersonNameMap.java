package com.example.orika.listmapandarraymapping;

import java.util.Map;

/*
* Here, our source object has a map of values. We know there is a key in that map,
* first, whose value represents a person's firstName in our destination object.
* Likewise we know that there is another key, last,
* in the same map whose value represents a person's lastName in the destination object.
* */

public class PersonNameMap {
    private Map<String, String> nameMap;

    public PersonNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }

    public Map<String, String> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }
}
