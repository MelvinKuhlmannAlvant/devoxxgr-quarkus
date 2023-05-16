package nl.alvant.resource;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import nl.alvant.client.CountriesClient;
import nl.alvant.model.Country;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;

@Path("/countries")
public class CountriesResource {

    private final CountriesClient client;

    public CountriesResource(@RestClient CountriesClient client) {
        this.client = client;
    }

    @GET
    public Uni<List<Country>> hello(@RestQuery List<String> names) {
        return client.getAll();
    }
}
