package pro.sky.coursework2.Service;

import pro.sky.coursework2.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> qetQuestions(int amount);
}
