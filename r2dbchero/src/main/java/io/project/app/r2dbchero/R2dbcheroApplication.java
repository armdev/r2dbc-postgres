package io.project.app.r2dbchero;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication

@ComponentScan("io.project")
@EntityScan("io.project.app.r2dbchero.domain")
public class R2dbcheroApplication {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(R2dbcheroApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }

}
