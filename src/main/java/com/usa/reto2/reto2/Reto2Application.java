package com.usa.reto2.reto2;

import com.usa.reto2.reto2.repository.crud.FraganceCrudRepository;
import com.usa.reto2.reto2.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {

	@Autowired
	private FraganceCrudRepository fraganceCrudRepository;

	@Autowired
	private UserCrudRepository userCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fraganceCrudRepository.deleteAll();
		userCrudRepository.deleteAll();
	}


}

