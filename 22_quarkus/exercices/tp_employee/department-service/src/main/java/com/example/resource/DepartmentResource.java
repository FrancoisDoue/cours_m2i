package com.example.resource;

import com.example.entity.Department;
import com.example.service.DepartmentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/api/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;

    @GET
    public Response getAll() {
        return Response.ok(departmentService.getDepartments()).build();
    }

    @POST
    public Response create(Department department) {
        return Response.status(Response.Status.CREATED)
                .entity(departmentService.createDepartment(department)).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok(departmentService.getDepartment(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Department department) {
        return Response.ok(departmentService.updateDepartment(id, department)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        departmentService.deleteDepartment(id);
        return Response.noContent().build();
    }
}
