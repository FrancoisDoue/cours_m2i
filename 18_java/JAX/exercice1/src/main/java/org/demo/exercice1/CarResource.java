package org.demo.exercice1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.demo.entity.Car;
import org.demo.service.CarService;
import org.demo.service.CarServiceOld;

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
        return carService.getCarById(id);
    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Car createCar(Car car) {
//        carService.createCar(car);
//        return car;
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCar(Car car) {
        car = carService.createCar(car);
        if (car != null) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(car)
                    .build();
        }
        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(Car car) {
        return carService.updateCar(car);
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") int id) {
        carService.deleteCarById(id);
    }



}
