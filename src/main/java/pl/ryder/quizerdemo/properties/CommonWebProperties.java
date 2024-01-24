package pl.ryder.quizerdemo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("quizer")
@Component
@Getter
@Setter
public class CommonWebProperties {
    private String title = "demo";

}
