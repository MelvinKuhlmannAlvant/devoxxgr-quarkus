package nl.alvant;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@ExtendWith({PactConsumerTestExt.class})
@PactTestFor(port = "8085")
public class SouthboundResourceContractTest {

    @Pact(consumer = "SouthboundResource")
    public V4Pact getSouthboundGreetingPact(PactDslWithProvider builder) {
        return builder
                .uponReceiving("get southbound greeting")
                .path("/southbound")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("Hello from southbound")
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "getSouthboundGreetingPact")
    public void testSouthboundGreeting() {
        var response = given()
                .body("")
                .when()
                .get("http://localhost:8085/southbound")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();

        assertEquals("Hello from southbound", response);
    }
}
