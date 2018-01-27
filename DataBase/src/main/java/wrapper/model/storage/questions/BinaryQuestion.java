package wrapper.model.storage.questions;

import wrapper.model.enums.QuestionType;
import wrapper.model.storage.Question;

public class BinaryQuestion extends Question {

    String quetion;

    public BinaryQuestion() {
        super(QuestionType.BinaryQuestion);
    }
}
