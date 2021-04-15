package com.learning.core.java.capture5.abstractDemo;

import java.util.Objects;

public abstract class Persion {

    public abstract String getDescription();

    private String name;

    public Persion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
