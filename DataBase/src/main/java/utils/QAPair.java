package utils;

public class QAPair<Q, A> {
    protected Q question;
    protected A answer;

    public QAPair(Q question, A answer) {
        super();
        this.question = question;
        this.answer = answer;
    }
}
