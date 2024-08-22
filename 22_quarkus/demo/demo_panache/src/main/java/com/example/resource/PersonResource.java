package com.example.resource;

import com.example.entity.Person;
import com.example.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;


@Path("/api/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @GET
    public Response getPersons() {
        return Response.ok(
                personService.findAllPersons()
        ).build();
    }

    @GET
    @Path("/search")
    public Response getPerson(@QueryParam("firstname") String firstname) {
        return Response.ok(
                personService.findPersonByFirstname(firstname)
        ).build();
    }

    @POST
    public Response createPerson(Person person) {
        return Response
                .status(Response.Status.CREATED)
                .entity(personService.createPerson(person.getFirstname(), person.getLastname(), person.getAge()))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") Long id) {
        return personService.findPersonById(id)
                .map(p -> Response.ok(p).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        personService.deletePersonById(id);
        return Response.noContent().build();
    }

}
