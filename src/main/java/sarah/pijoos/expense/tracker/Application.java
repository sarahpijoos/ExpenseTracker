package sarah.pijoos.expense.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class of the SpringBoot Application The class is annotated with
 * {@code @SpringBootApplication} to indicate that this is the starting point for the application.
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
