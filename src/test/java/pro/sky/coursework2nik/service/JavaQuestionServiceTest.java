package pro.sky.coursework2nik.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2nik.entity.Question;
import pro.sky.coursework2nik.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.HashSet;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;


    @Test
    void add() {
        //Подготовка входных данных
        String question = "question_1";
        String answer = "answer_1";

        //Подготовка ожидаемого результат
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);

        //Начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
        verify(javaQuestionRepository).add(expectedQuestion);
    }

    @Test
    void remove() {
        //подготовка входных данных
        String question = "question_1";
        String answer = "answer_1";
        //подготовка ожидаемого результата
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);
        //начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void getAll() {
        String question = "question_1";
        String answer = "answer_1";
        String question1 = "question_2";
        String answer1 = "answer_2";
        String question2 = "question_3";
        String answer2 = "answer_3";
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question(question, answer));
        expected.add(new Question(question1, answer1));
        expected.add(new Question(question2, answer2));
        //Начало теста
        when(javaQuestionService.getAll()).thenReturn(expected);
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(expected, actual);
    }
}