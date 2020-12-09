package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RestController
@EnableAutoConfiguration


public class Main {
	@RequestMapping("/")
	String home() {
		return "A test to check and see if localhost:8080 works!";
	}
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
