package example.micronaut;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.HttpRequest;
import io.micronaut.context.ApplicationContext;

import org.junit.jupiter.api.Test;
import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class WelcomeControllerTest {

    @Inject
    static EmbeddedServer embeddedServer;
    @Inject
    static HttpClient client;

    @Test
    public void shouldReturnHello() {
        embeddedServer = ApplicationContext.run(EmbeddedServer.class);
        client = HttpClient.create(this.embeddedServer.getURL());

        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/welcome/Suthagar"));
        assertEquals(response, "Hello Suthagar");

        embeddedServer.stop();
        client.close();
    }
}

