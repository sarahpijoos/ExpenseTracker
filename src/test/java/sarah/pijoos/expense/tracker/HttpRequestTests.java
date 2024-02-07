package sarah.pijoos.expense.tracker;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void endpointShouldReturnGreetingAndName()throws Exception{

        JsonObject expected = new JsonObject();
        expected.addProperty("name", "Sarah");

        assertThat(this.testRestTemplate.getForObject("http://localhost:" +
                port + "/hello/Sarah", String.class)).isEqualTo(expected.toString());

    }
}
