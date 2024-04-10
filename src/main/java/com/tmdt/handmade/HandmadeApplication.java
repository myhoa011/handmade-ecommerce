package com.tmdt.handmade;

import com.tmdt.handmade.dto.account.UserDTO;
import com.tmdt.handmade.entity.account.User;
import com.tmdt.handmade.repository.UserRepository;
import com.tmdt.handmade.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HandmadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandmadeApplication.class, args);
	}

}
