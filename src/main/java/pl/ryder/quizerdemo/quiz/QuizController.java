package pl.ryder.quizerdemo.quiz;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class QuizController {
    private final QuizRepository quizRepository;

    @GetMapping(produces = "application/json")
    public Quizzes getAllQuizzes() {
        return new Quizzes(StreamSupport.stream(quizRepository
                                .findAll()
                                .spliterator(),
                        false)
                .toArray(Quiz[]::new));

    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        var quiz = quizRepository.findById(id);
        return quiz.orElse(null);
    }

}
