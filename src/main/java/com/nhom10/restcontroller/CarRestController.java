package com.nhom10.restcontroller;

import com.nhom10.model.Car;
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
@RequestMapping("/car")
@CrossOrigin("*")
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
        Optional<Car> optionalCar = carService.findById(id);
        Car car = optionalCar.get();
        return new ResponseEntity<Car>(car,HttpStatus.OK);

    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createCar(@RequestBody Car car){
        carService.save(car);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){
        Optional<Car> optionalCar = carService.findById(id);
        if (!optionalCar.isPresent()){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }else {
            car.setLicensePlate(car.getLicensePlate());
            car.setColor(car.getColor());
            car.setManufactured(car.getManufactured());
            car.setModel(car.getModel());
            car.setYearManufactured(car.getYearManufactured());
            car.setSeats(car.getSeats());
            car.setLongevity(car.getLongevity());
            car.setLastMaintenance(car.getLastMaintenance());
            carService.save(car);
            return new ResponseEntity<Car>(car,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id){
        Optional<Car> car = carService.findById(id);
        if (!car.isPresent()){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }else {
            carService.remove(id);
            return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
        }
    }
    //Tim kiem theo bien so xe
    @GetMapping(value= "/find-by-license-plate/{lp}")
    public ResponseEntity<List<Car>> findByLicensePlate(@PathVariable("lp") String lp){
        List<Car> carsList=carService.findByLicensePlate(lp);
        if (carsList.isEmpty()){
            return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Car>>(carsList,HttpStatus.OK);
        }
    }
//    //Tim kiem theo bien so xe
//    @GetMapping(value= "/find-by-license-plate/{lp}")
//    public ResponseEntity<Car> findByLicensePlate(@PathVariable("lp") String lp){
//        Optional<Car> optionalCar = carService.findByLicensePlate(lp);
//        return optionalCar.map(car -> new ResponseEntity<>(car, HttpStatus.FOUND))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//    // Tim kiem theo hang san xuat
//    @GetMapping(value= "/find-by-manufactured/{mf}")
//    public ResponseEntity<Car> findByManufactured(@PathVariable("mf") String mf){
//        Optional<Car> optionalCar = carService.findByManufactured(mf);
//        return optionalCar.map(car -> new ResponseEntity<>(car, HttpStatus.FOUND))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}
