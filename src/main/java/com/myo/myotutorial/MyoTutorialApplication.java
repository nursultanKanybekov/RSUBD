package com.myo.myotutorial;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "MYO Home tutorial",
                version = "1.0.0",
                description = "Home work: try it in home"
        )
)
public class MyoTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyoTutorialApplication.class, args);
    }

}
