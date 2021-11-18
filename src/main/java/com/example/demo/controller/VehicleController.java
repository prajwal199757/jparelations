package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicle")
    public List<Vehicle> getVehicle()
    {
        return vehicleService.getVehicle();
    }

    @PostMapping("addVehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle)
    {
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("vehicle/{id}")
    public Optional<Vehicle> getVehicleDetails(@PathVariable Long id)
    {
        return vehicleService.getVehicleDetails(id);
    }

    @GetMapping("vehicle/brand")
    public List<Vehicle> getDetailsByBrand(@RequestParam(name = "brand") String brand){
        return vehicleService.getDetailsByBrand(brand);
    }

    @DeleteMapping("vehicle/{id}")
    public void deleteVehicle(@PathVariable Long id)
    {
        vehicleService.deleteVehicle(id);
    }

//    @DeleteMapping("delete/personId")
//    public void deleteNullVehicle()
//    {
//        vehicleService.deleteNullVehicle();
//    }

}
