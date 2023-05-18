package nl.alvant.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import nl.alvant.client.SouthboundServiceClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/southbound")
public class SouthboundResource {

    @RestClient
    SouthboundServiceClient client;

    @GET
    public String greetingFromSouthbound() {
        return client.getGreeting();
    }
}
