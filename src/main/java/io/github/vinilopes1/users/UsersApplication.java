package io.github.vinilopes1.users;

import io.github.vinilopes1.users.model.entity.User;
import io.github.vinilopes1.users.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsersApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(UsersApplication.class);
    }
}
