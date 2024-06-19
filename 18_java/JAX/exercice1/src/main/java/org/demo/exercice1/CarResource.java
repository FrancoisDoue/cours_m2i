package org.demo.exercice1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.demo.entity.Car;
import org.demo.service.CarService;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GET
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GET
    @Path("/{id}")
    public Car getCar(@PathParam("id") int id) {
        return carService.getCar(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Car createCar(Car car) {
        carService.getCars().add(car);
        return car;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(Car car) {
        return carService.updateCar(car);
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") int id) {
        carService.deleteCar(id);
    }



}
