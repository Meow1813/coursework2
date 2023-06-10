package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Excepton.QuestionAmountException;
import pro.sky.coursework2.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> qetQuestions(int amount) {
        if (amount > questionService.getAll().size()){
            throw new QuestionAmountException();
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size()<amount){
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
