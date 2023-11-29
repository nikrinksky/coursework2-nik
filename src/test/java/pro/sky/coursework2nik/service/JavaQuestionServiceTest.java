package pro.sky.coursework2nik.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2nik.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService = new JavaQuestionService();
    Collection<Question> DATASET;

    {
        DATASET = new HashSet<>(Set.of(
                new Question("вопрос", "ответ"),
                new Question("вопрос 1", "ответ 1"),
                new Question("вопрос 2", "ответ 2"),
                new Question("вопрос 3", "ответ 3"),
                new Question("вопрос 4", "ответ 4")));
    }

    @BeforeEach
    public void setUp() {
        javaQuestionService.add(new Question("вопрос", "ответ"));
        javaQuestionService.add(new Question("вопрос 1", "ответ 1"));
        javaQuestionService.add(new Question("вопрос 2", "ответ 2"));
        javaQuestionService.add(new Question("вопрос 3", "ответ 3"));
        javaQuestionService.add(new Question("вопрос 4", "ответ 4"));
    }


    @Test
    void add() {
        var actual = javaQuestionService.add(new Question("вопрос1", "ответ1"));
        var expected = new Question("вопрос1", "ответ1");

        assertEquals(actual, expected);
    }

    @Test
    void remove() {
        var actual = javaQuestionService.remove("вопрос", "ответ");
        var expected = new Question("вопрос", "ответ");

        assertEquals(actual, expected);
    }

    @Test
    void getAll() {
        var actual = javaQuestionService.getAll();
        var expected = DATASET;
        assertEquals(expected, actual);
    }
}