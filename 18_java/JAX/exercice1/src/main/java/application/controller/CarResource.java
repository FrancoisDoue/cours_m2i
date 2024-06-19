package application.controller;

import application.entity.Car;
import application.service.CarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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

    @POST
    public Car createCar(Car car) {
        return carService.createCar(car);
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response newCar(Car car) {
//        try {
//            car = carService.createCar(car);
//            if (car != null)
//                throw new Exception("Nope.");
//            return Response.status(Response.Status.CREATED).entity(car).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
//        }
//    }

    @PUT
    public Car updateCar(Car car) {
        return carService.updateCar(car);
    }

    @PATCH
    @Path("/{id}")
    public Car patchCar(@PathParam("id") int id, Car car) {
        return carService.patchCar(carService.getCarById(id), car);
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") int id) {
        carService.deleteCarById(id);
    }


}
