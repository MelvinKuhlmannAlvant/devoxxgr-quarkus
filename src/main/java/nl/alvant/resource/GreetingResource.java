package nl.alvant.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/greeting")
public class GreetingResource {

    @GET
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
