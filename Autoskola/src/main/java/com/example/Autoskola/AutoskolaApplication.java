package com.example.Autoskola;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Autoskola.Instructor.Instructor;

@SpringBootApplication
@RestController
public class AutoskolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoskolaApplication.class, args);
	}

	@GetMapping
	public List<Instructor> instructor(){
		return List.of(
				new Instructor("Marian", 47, 1L)
		);
	}

}
