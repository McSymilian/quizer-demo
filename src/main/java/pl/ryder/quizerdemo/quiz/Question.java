package pl.ryder.quizerdemo.quiz;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String imageUrl;

    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
}
