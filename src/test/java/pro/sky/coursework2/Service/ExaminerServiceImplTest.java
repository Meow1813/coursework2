package pro.sky.coursework2.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.Excepton.QuestionAmountException;
import pro.sky.coursework2.domain.Question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        out = new ExaminerServiceImpl(questionService);
    }

    @Mock
    private QuestionService questionService;

    private final Set<Question> QUESTIONS = new HashSet<>(Arrays.asList(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4"),
            new Question("question5", "answer5"),
            new Question("question6", "answer6"),
            new Question("question7", "answer7")));

    @Test
    void qetQuestions() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4"),
                new Question("question5", "answer5"),
                new Question("question6", "answer6"),
                new Question("question7", "answer7"));
        assertTrue(QUESTIONS.containsAll(out.qetQuestions(3)));
    }

    @Test
    void qetQuestionsWrongAmount() {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertThrows(QuestionAmountException.class, () -> out.qetQuestions(32));
    }

}