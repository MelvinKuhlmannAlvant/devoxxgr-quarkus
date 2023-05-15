package nl.alvant;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @GET
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/index")
    public String index() {
        return "Quarkus index endpoint";
    }
}
