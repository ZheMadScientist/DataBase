package ru.compscience.database;

public class Pair <A, B> {
    protected A question;
    protected B answer;

    public Pair(A question, B answer) {
        super();
        this.question = question;
        this.answer = answer;
    }
}
