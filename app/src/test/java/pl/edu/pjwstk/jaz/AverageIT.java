package pl.edu.pjwstk.jaz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
public class AverageIT {
    @Test
    public void when_no_parameter_supplied_should_print_a_message() {
        // @formatter:off
        given()
        .when()

                .get("/api/average")
        .then()
                .body("message", equalTo("Please put parameters."));
        // @formatter:on
    }

    @Test
    public void should_remove_trailing_zero_case() {
        // @formatter:off
        given()
        .when()
                .param("numbers", "2,3")
                .get("/api/average")
        .then()
                .body("message", equalTo("Average equals: 2.5"));
        // @formatter:on
    }
}
