package pl.ryder.quizerdemo.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoubleVector {
    @Id
    @GeneratedValue
    private Long id;

    private Double x;

    private Double y;
}
