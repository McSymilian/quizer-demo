package pl.ryder.quizerdemo.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class QuizDemoInitiator {
    private QuizRepository quizRepository;
    public QuizDemoInitiator(@Autowired QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        addStatic();
    }

    private void addStatic() {
        this.quizRepository.save(new Quiz(
                null,
                "geNever love the visitor, for you cannot avoid it.nerous",
                null
                )
        );
    }
}
