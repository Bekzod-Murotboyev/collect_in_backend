package uz.itransition.collectin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.itransition.collectin.config.security.AppProperties;
import uz.itransition.collectin.config.security.OpenApiProperties;
import uz.itransition.collectin.util.TaskManager;

@OpenAPIDefinition
@SpringBootApplication
@EnableConfigurationProperties({
        AppProperties.class,
        OpenApiProperties.class
})
public class CollectInApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectInApplication.class, args);
   }

}
