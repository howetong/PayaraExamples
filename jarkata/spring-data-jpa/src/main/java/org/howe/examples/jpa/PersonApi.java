package org.howe.examples.jpa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.howe.examples.jpa.entity.Person;
import org.howe.examples.jpa.service.PersonService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/person")
@ApplicationScoped
@Tag(description = "Person API", name = "Person")
public class PersonApi {

    private static final Logger LOG = Logger.getLogger(PersonApi.class.getName());

    @Inject
    private PersonService personService;

    @POST
    public Response createPerson(Person person) {
        LOG.log(Level.FINE, "rest request to save person : {0}", person);
        personService.save(person);
        return Response.ok(person).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Endpoint that get person")
    public Response getPerson(
            @PathParam("id")
            @Parameter(name = "id") Long id) {
        LOG.log(Level.FINE, "REST request to get Person : {0}", id);
        Person person = personService.findById(id);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(person).build();
        }
    }
}


