package com.example.resource;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/api/employees")
public class EmployeeResource {
    @Inject
    EmployeeService employeeService;

    @GET
    public Response getEmployees() {
        return Response.ok(employeeService.getAllEmployees()).build();
    }

    @POST
    public Response createEmployee(Employee employee) {
        return Response.status(Response.Status.CREATED).entity(employeeService.createEmployee(employee)).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") Long id, @QueryParam("detail") Boolean detail) {
        if (detail != null && detail) {
            return Response.ok(employeeService.getDetailedEmployeeById(id)).build();
        }
        return Response.ok(employeeService.getEmployeeById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") Long id, Employee employee) {
        return Response.ok(employeeService.updateEmployee(id, employee)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/department/{departmentId}")
    public Response getEmployeeByDepartmentId(@PathParam("departmentId") Long departmentId) {
        return Response.ok(employeeService.getEmployeesByDepartmentId(departmentId)).build();
    }

    @GET
    @Path("/organization/{organizationId}")
    public Response getEmployeeByOrganizationId(@PathParam("organizationId") Long organizationId) {
        return Response.ok(employeeService.getEmployeesByOrganizationId(organizationId)).build();
    }

    @GET
    @Path("/organization/{organizationId}/count")
    public Response getCountByOrganizationId(@PathParam("organizationId") Long organizationId) {
        return Response.ok(employeeService.countEmployeesByOrganizationId(organizationId)).build();
    }

    @GET
    @Path("/departmentless")
    public Response getEmployeesIsDepartmentless() {
        return Response.ok(employeeService.getEmployeesByDepartmentId(null)).build();
    }

    @GET
    @Path("/organizationless")
    public Response getEmployeesIsOrganizationless() {
        return Response.ok(employeeService.getEmployeesByOrganizationId(null)).build();
    }


}
