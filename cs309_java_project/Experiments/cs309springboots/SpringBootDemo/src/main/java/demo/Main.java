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
return "This is a test for springboot for Com S 309 Group RP_02, Daniel King";
}
public static void main(String[] args) {
SpringApplication.run(Main.class, args);
}
}
