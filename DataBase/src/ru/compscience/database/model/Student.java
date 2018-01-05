package ru.compscience.database.model;

import ru.compscience.database.utils.Pair;

import java.util.List;

public class Student {

    private String name;
    private String secondName;
    private String group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List< Pair <Question, Answer> > history;

    public boolean getTaskResult(Question question, Answer answer){
        return false;
    }

}
