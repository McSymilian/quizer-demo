package pl.ryder.quizerdemo.quiz.answer;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoubleVector {
    private Double x;

    private Double y;
}
