package pl.ryder.quizerdemo.quiz;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ryder.quizerdemo.quiz.answer.Answer;
import pl.ryder.quizerdemo.quiz.answer.AnswerRepository;
import pl.ryder.quizerdemo.quiz.answer.DoubleVector;
import pl.ryder.quizerdemo.quiz.question.Question;
import pl.ryder.quizerdemo.quiz.question.QuestionRepository;
import pl.ryder.quizerdemo.quiz.quiz.Quiz;
import pl.ryder.quizerdemo.quiz.quiz.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class QuizDemoInitiator {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    public QuizDemoInitiator(@Autowired QuizRepository quizRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;

        addStatic();
    }

    private void addStatic() {
        var questions = getQuestions();
        questionRepository.saveAll(questions);
        var quiz = new Quiz(
                null,
                "Ameno Interimo",
                questions,
                "https://focusesbyf.pqh"
        );

        quizRepository.save(quiz);
    }

    private List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        var rand = new Random(System.nanoTime());
        for (int i = 0, end = rand.nextInt(2, 6); i < end; i++) {
            var answers = getAnswers();
            answerRepository.saveAll(answers);

            questions.add(new Question(
                    null,
                    "Christophr",
                    "Aware findarticles shine separation francisco circumstances olympics, cyprus dispute bold whale gun induced loud, contamination jay personalized snake. ",
                    "https://consideration5fsr1qwiluji.xij",
                    answers
                    )
            );
        }

        return questions;
    }

    @NotNull
    private static List<Answer> getAnswers() {
        return List.of(
                new Answer(
                        null,
                        "Cur sectam peregrinationes?",
                        "",
                        new DoubleVector(1D, 0D)
                ),
                new Answer(
                        null,
                        "Nunquam vitare lamia?",
                        "",
                        new DoubleVector(0D, 0D)
                ),
                new Answer(
                        null,
                        "Cur abnoba trabem?",
                        "",
                        new DoubleVector(0D, 0D)
                )
        );
    }
}
