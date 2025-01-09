package com.desafio.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoApplication {


	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

 /*
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("crip 123456 "+encoder.encode("123456"));
	}

  */
}
