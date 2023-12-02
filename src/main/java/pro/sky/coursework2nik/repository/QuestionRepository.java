package pro.sky.coursework2nik.repository;

import pro.sky.coursework2nik.entity.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

}
