package com.segware.upvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UpvoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpvoteApplication.class, args);
	}

}
