package nz.mashupapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class MashupApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MashupApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MashupApplication.class, args);
    }

    /*@Bean
    public RestTemplate restTemplate1(RestTemplateBuilder builder) {
        return builder.build();
    }*/
}

