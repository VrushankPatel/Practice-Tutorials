package com.example.orika.mapnestedfields;

// Here this class has object of Name class, Name class has two fields firstName and lastName.
// Our task is to map this class to PersonNameParts class,
// in the nutshell, we've to map nested class of this class to destination class.

public class PersonContainer {
    private Name name;

    public PersonContainer(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
