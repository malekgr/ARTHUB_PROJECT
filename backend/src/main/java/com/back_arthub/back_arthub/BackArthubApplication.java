package com.back_arthub.back_arthub;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class BackArthubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackArthubApplication.class, args);
	}

}
