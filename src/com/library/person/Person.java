package com.library.person;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String whoYouAre() {
        return this.name;
    }
}
