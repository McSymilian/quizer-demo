package pl.ryder.quizerdemo.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.ryder.quizerdemo.properties.CommonWebProperties;
import pl.ryder.quizerdemo.quiz.QuizRepository;

@Controller
@AllArgsConstructor
public class Home {
    private QuizRepository quizRepository;

    private CommonWebProperties properties;

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("title", properties.getTitle());
        model.addAttribute("quizzes", quizRepository.findAll());

        return "home";
    }
}
