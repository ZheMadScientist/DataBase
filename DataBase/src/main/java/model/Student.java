package model;

import  utils.QAPair;

import java.util.List;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String secondName;

    @NotNull
    private String group;


    public List <QAPair <Question, Answer> > history;

    public boolean getTaskResult(Question question, Answer answer){
        return false;
    }

}
