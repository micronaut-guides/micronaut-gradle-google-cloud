package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class HelloControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testHello() throws Exception {
        HttpRequest request = HttpRequest.GET("/");
        String body = client.toBlocking().retrieve(request);
        Assertions.assertNotNull(body);
        Assertions.assertEquals(
                "Micronaut on App Engine",
                body
        );
    }
}