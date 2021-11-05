package org.howe.examples.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/api/person")
@ApplicationScoped

public class PersonController {

    private static final Logger LOG = Logger.getLogger(PersonController.class.getName());

    @Inject
    private PersonRepository personRepository;

    @POST
    public Response createPerson(Person person) {
        LOG.log(Level.FINE, "rest request to save person : {0}", person);
        personRepository.create(person);
        return Response.ok(person).build();
    }

    @GET
    @Path("/{id}")
    public Response getPerson(@PathParam("id") Long id) {
        LOG.log(Level.FINE, "REST request to get Person : {0}", id);
        Person person = personRepository.find(id);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(person).build();
        }
    }
}


