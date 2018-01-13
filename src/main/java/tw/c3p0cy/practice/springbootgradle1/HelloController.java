package tw.c3p0cy.practice.springbootgradle1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

  @GetMapping
  public String hello() {
    return "Hello Spring Boot @ " + System.currentTimeMillis();
  }
}
