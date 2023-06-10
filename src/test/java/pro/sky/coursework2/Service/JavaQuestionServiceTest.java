package pro.sky.coursework2.Service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();


    @Test
    void add() {
        Set<Question> set = new HashSet<>();
        set.add(new Question("Вопрос", "Ответ"));
        out.add("Вопрос", "Ответ");
        assertEquals(set, out.getAll());
    }

    @Test
    void remove() {
        Set<Question> set = new HashSet<>();
        out.add("Вопрос", "Ответ");
        out.remove(new Question("Вопрос", "Ответ"));
        assertEquals(set, out.getAll());
    }

    @Test
    void getAll() {
        Set<Question> set = new HashSet<>();
        out.add("question", "answer");
        out.add("вопрос", "answer");
        out.add("question", "ответ");
        out.add("вопрос", "ответ");
        out.add("Вопрос", "answer");
        set.add(new Question("question", "answer"));
        set.add(new Question("вопрос", "answer"));
        set.add(new Question("question", "ответ"));
        set.add(new Question("вопрос", "ответ"));
        set.add(new Question("Вопрос", "answer"));
        assertEquals(set, out.getAll());
    }


    @Test
    void getRandomQuestion() {
        out.add("question", "answer");
        out.add("вопрос", "answer");
        out.add("question", "ответ");
        out.add("вопрос", "ответ");
        out.add("Вопрос", "answer");
        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}