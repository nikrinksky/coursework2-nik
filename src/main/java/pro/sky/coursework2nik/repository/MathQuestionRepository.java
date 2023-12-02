package pro.sky.coursework2nik.repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursework2nik.entity.Question;

import java.util.Collection;
import java.util.HashSet;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Collection<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
