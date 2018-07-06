package com.repnation.webrep;

import com.repnation.webrep.domain.model.User;
import com.repnation.webrep.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class WebrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebrepApplication.class, args);
	}
}
