package org.demo.exercice1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.demo.entity.Car;
import org.demo.service.CarService;

import java.util.List;

@Path("/cars")
public class CarResource {

    CarService carService = new CarService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Car> getCars() {
        return carService.getCars();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") String id) {
        return carService.getCar(Integer.parseInt(id));
    }

}
