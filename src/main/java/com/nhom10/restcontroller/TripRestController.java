package com.nhom10.restcontroller;


import com.nhom10.model.Car;
import com.nhom10.model.Trip;
import com.nhom10.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/trip")
public class TripRestController {
    @Autowired
    private TripService tripService;
    @GetMapping("/list")
    public ResponseEntity<List<Trip>> showTripList(){
        List<Trip>tripList;
        tripList = tripService.findAll();
        if (tripList.isEmpty()){
            return new ResponseEntity<List<Trip>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Trip>>(tripList, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Trip> findTripById(@PathVariable Long id){
        Optional<Trip> optionalTrip = tripService.findById(id);
        Trip trip = optionalTrip.get();
        return new ResponseEntity<Trip>(trip,HttpStatus.OK);

    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createTrip(@RequestBody Trip trip){
        tripService.save(trip);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip){
        Optional<Trip> optionalTrip = tripService.findById(id);
        if (!optionalTrip.isPresent()){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }else {
            trip.setBuses(trip.getBuses());
            trip.setDriver(trip.getDriver());
            trip.setSubDriver(trip.getSubDriver());
            trip.setGuestNumber(trip.getGuestNumber());
            trip.setPrice(trip.getPrice());
            tripService.save(trip);
            return new ResponseEntity<Trip>(trip,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable Long id){
        Optional<Trip> trip = tripService.findById(id);
        if (!trip.isPresent()){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }else {
            tripService.remove(id);
            return new ResponseEntity<Trip>(HttpStatus.NO_CONTENT);
        }
    }
    //findByGuestNumber
    @GetMapping(value = "/find-by-guest-number/{number}")
    public ResponseEntity<Trip> findByGuestNumber(@PathVariable("number") int number ) {
        Optional<Trip> optionalTrip = tripService.findByGuestNumber(number);
        return optionalTrip.map(trip -> new ResponseEntity<>(trip, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //findByPrice
    @GetMapping(value = "/find-by-price/{price}")
    public ResponseEntity<List<Trip>> findByPrice(@PathVariable("price") float price ) {
        List<Trip> tripList=tripService.findByPrice(price);
        if (tripList.isEmpty()){
            return new ResponseEntity<List<Trip>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Trip>>(tripList,HttpStatus.OK);
        }
    }
//    @GetMapping("/count-trip-by-driver")
//    public ResponseEntity<List<Trip>> showTripCountList(@RequestBody Long id){
//        List<Trip>tripList;
//        tripList = tripService.countTripByDriver(id);
//        if (tripList.isEmpty()){
//            return new ResponseEntity<List<Trip>>(HttpStatus.NOT_FOUND);
//        }else {
//            return new ResponseEntity<List<Trip>>(tripList, HttpStatus.OK);
//        }
//    }

}