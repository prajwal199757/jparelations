package com.example.demo.services;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> getVehicle() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleDetails(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> getDetailsByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

//    public void deleteNullVehicle() {
//        Iterable<Vehicle> resultSet = vehicleRepository.findAll();
//        for (Vehicle result:
//        resultSet) {
//            if (result.getPersonId()==null)
//            {
//                vehicleRepository.delete(result);
//            }
//        }
//    }
}
