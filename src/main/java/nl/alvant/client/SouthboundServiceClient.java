package nl.alvant.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "southbound-api")
@Path("/greeting")
public interface SouthboundServiceClient {

    @GET
    String getGreeting();
}
