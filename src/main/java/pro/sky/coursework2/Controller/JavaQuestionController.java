package pro.sky.coursework2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.Service.JavaQuestionService;
import pro.sky.coursework2.domain.Question;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionService service;

    JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.service = javaQuestionService;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return service.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.remove(new Question(question, answer));
    }
}
