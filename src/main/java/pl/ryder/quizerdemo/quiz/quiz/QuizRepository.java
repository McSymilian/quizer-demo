package pl.ryder.quizerdemo.quiz.quiz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
