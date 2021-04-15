package com.learning.core.java.capture5.abstractDemo;

public class Students extends  Persion {

    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Students(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in "+ major;
    }
}
