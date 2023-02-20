package foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogbackIfElseApplication {

  private static final Logger LOG = LoggerFactory.getLogger(LogbackIfElseApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(LogbackIfElseApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner() {
    return args -> {
      LOG.info("Hello Logback!");
      System.out.println("Hello stdout");
    };
  }

}
