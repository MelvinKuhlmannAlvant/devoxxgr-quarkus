package nl.alvant;


import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import nl.alvant.client.SouthboundServiceClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
public class SouthboundServiceClientTest {

    @InjectMock
    @RestClient
    SouthboundServiceClient client;

    @BeforeEach
    public void setUp() {
        when(client.getGreeting()).thenReturn("Hello from southbound");
    }

    @Test
    public void testSouthboundGreeting() {
        var response = given()
                .body("")
                .when()
                .get("/southbound")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();

        assertEquals("Hello from southbound", response);
    }
}
