package com.nhom10.restcontroller;

import com.nhom10.model.Employee;
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
        Optional<Trip> trip = tripService.findById(id);
        Trip trip1 = trip.get();
        if (trip1 == null){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }else {
            tripService.save(trip1);
            return new ResponseEntity<Trip>(trip1,HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createTrip(@RequestBody Trip trip){
        tripService.save(trip);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip){
        Optional<Trip> trip1 = tripService.findById(id);
        Trip trip2 = trip1.get();
        if (trip2 == null){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }else {
            trip2.setBuses(trip.getBuses());
            trip2.setDriver(trip.getDriver());
            trip2.setSubDriver(trip.getSubDriver());
            trip2.setGuestNumber(trip.getGuestNumber());
            trip2.setPrice(trip.getPrice());
            tripService.save(trip2);
            return new ResponseEntity<Trip>(trip2,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable Long id){
        Optional<Trip> trip = tripService.findById(id);
        if (trip == null){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }else {
            tripService.remove(id);
            return new ResponseEntity<Trip>(HttpStatus.NO_CONTENT);
        }
    }
    //findByGuestNumber
    @GetMapping(value = "/find-by-guest-number/{number}")
    public ResponseEntity<Trip> findByGuestNumber(@PathVariable("number") int number ) {
        Optional<Trip> trip = tripService.findByGuestNumber(number);
        Trip trip1 = trip.get();
        if (trip1 == null) {
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Trip>(trip1, HttpStatus.OK);
        }
    }
    //findByPrice
    @GetMapping(value = "/find-by-price/{price}")
    public ResponseEntity<Trip> findByPrice(@PathVariable("price") float price ) {
        Optional<Trip> trip = tripService.findByPrice(price);
        Trip trip1 = trip.get();
        if (trip1 == null) {
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Trip>(trip1, HttpStatus.OK);
        }
    }
}
