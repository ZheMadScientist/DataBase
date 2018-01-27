package wrapper.model.storage;


import wrapper.model.enums.QuestionType;
import wrapper.model.enums.TaskType;

public class Question extends Task{
    QuestionType questionType;

    public Question(QuestionType questionType) {
        super(TaskType.Question);

        this.questionType = questionType;
    }
}
