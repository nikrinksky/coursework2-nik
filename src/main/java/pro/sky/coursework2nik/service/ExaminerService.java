package pro.sky.coursework2nik.service;

import pro.sky.coursework2nik.entity.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int size);
}
