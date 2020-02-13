package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;

import javax.validation.constraints.NotBlank;

@Controller("/welcome")
public class WelcomeController {

    @Get("/{name}")
    @Produces(MediaType.TEXT_PLAIN) // <3>
    public String index(@NotBlank String name) {

        StringBuilder sb = new StringBuilder(3);
        sb.append("Hello").append(" ").append(name);

        return sb.toString(); // <4>
    }
}