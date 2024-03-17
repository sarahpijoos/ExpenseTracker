package sarah.pijoos.expense.tracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {

  // will fail if the application context cannot star
  @Test
  void contextLoads() {}

  @Test
  public void givenRawPassword_whenEncodedWithArgon2_thenMatchesEncodedPassword() {
    String rawPassword = "Baeldung";
    Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
    String springBouncyHash = arg2SpringSecurity.encode(rawPassword);

    boolean isValid = arg2SpringSecurity.matches(rawPassword, springBouncyHash);
    assertTrue(isValid);
  }
}
