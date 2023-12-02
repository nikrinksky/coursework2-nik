package pro.sky.coursework2nik.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2nik.entity.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceImpl;

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    public void setUp() {
        Collection<Question> questions = Stream.of(
                new Question("question_1", "answer_1"),
                new Question("question_2", "answer_2"),
                new Question("question_3", "answer_3"),
                new Question("question_4", "answer_4"),
                new Question("question_5", "answer_5")
        ).collect(Collectors.toSet());

        when(javaQuestionServiceImpl.getAll()).thenReturn(questions);
    }

    @Test
    void getQuestions() {
        List<Question> questions = new ArrayList<>(javaQuestionServiceImpl.getAll());

        when(javaQuestionServiceImpl.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(0),
                questions.get(2),
                questions.get(1)
        );
        assertThat(examinerServiceImpl.getQuestions(3))
                .containsExactly(questions.get(0), questions.get(1), questions.get(2));

        when(javaQuestionServiceImpl.getRandomQuestion()).thenReturn(
                questions.get(4),
                questions.get(3),
                questions.get(2),
                questions.get(0),
                questions.get(1),
                questions.get(2)
        );
        assertThat(examinerServiceImpl.getQuestions(5))
                .containsExactly(questions.get(4), questions.get(3),
                        questions.get(2), questions.get(0), questions.get(1));

    }
}