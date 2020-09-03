package com.nhom10.restcontroller;

import com.nhom10.model.Car;
import com.nhom10.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/car")
public class CarRestController {
    @Autowired
    private CarService carService;
    @GetMapping("/list")
    public ResponseEntity<List<Car>> showCarList(){
        List<Car>carList;
        carList = carService.findAll();
        if (carList.isEmpty()){
            return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Long id){
        Optional<Car> car = carService.findById(id);
        Car car1 = car.get();
        if (car1 == null){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }else {
            carService.save(car1);
            return new ResponseEntity<Car>(car1,HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createCar(@RequestBody Car car){
        carService.save(car);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){
        Optional<Car> car1 = carService.findById(id);
        Car car2 = car1.get();
        if (car2 == null){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }else {
            car2.setLicensePlate(car.getLicensePlate());
            car2.setColor(car.getColor());
            car2.setManufactured(car.getManufactured());
            car2.setModel(car.getModel());
            car2.setYearManufactured(car.getYearManufactured());
            car2.setSeats(car.getSeats());
            car2.setLongevity(car.getLongevity());
            car2.setLastMaintenance(car.getLastMaintenance());
            carService.save(car2);
            return new ResponseEntity<Car>(car2,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id){
        Optional<Car> car = carService.findById(id);
        if (car == null){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }else {
            carService.remove(id);
            return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
        }
    }
}
