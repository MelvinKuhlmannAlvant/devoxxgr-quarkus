package nl.alvant.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import nl.alvant.model.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "countries-api")
@Path("v3.1")
public interface CountriesClient {

    @GET
    @Path("all")
    Uni<List<Country>> getAll();
}
