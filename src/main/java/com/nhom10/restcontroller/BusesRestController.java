package com.nhom10.restcontroller;

import com.nhom10.model.Buses;
import com.nhom10.service.BusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buses")
@CrossOrigin("*")
public class BusesRestController {
    @Autowired
    private BusesService busesService;
    @GetMapping("/list")
    public ResponseEntity<List<Buses>> showBusesList(){
        List<Buses>busesList;
        busesList = busesService.findAll();
        if (busesList.isEmpty()){
            return new ResponseEntity<List<Buses>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Buses>>(busesList, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Buses> findBusesById(@PathVariable Long id){
        Optional<Buses> buses = busesService.findById(id);
        Buses buses1 = buses.get();
        if (buses1 == null){
            return new ResponseEntity<Buses>(HttpStatus.NOT_FOUND);
        }else {
            busesService.save(buses1);
            return new ResponseEntity<Buses>(buses1,HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createBuses(@RequestBody Buses buses){
        busesService.save(buses);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Buses> updateBuses(@PathVariable Long id, @RequestBody Buses buses){
        Optional<Buses> buses1 = busesService.findById(id);
        Buses buses2 = buses1.get();
        if (buses2 == null){
            return new ResponseEntity<Buses>(HttpStatus.NOT_FOUND);
        }else {
            buses2.setStartLocation(buses.getStartLocation());
            buses2.setEndLocation(buses.getEndLocation());
            buses2.setDistance(buses.getDistance());
            buses2.setLevel(buses.getLevel());
            busesService.save(buses2);
            return new ResponseEntity<Buses>(buses2,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Buses> deleteBuses(@PathVariable Long id){
        Optional<Buses> buses = busesService.findById(id);
        if (buses == null){
            return new ResponseEntity<Buses>(HttpStatus.NOT_FOUND);
        }else {
            busesService.remove(id);
            return new ResponseEntity<Buses>(HttpStatus.NO_CONTENT);
        }
    }
    //tim kiem theo diem dau hoac diem cuoi
    @GetMapping(value = "/find-by-location/{location}")
    public ResponseEntity<List<Buses>> findByLocation(@PathVariable ("location") String location ){
        List<Buses> busesList = busesService.findByLocation(location);
        if (busesList.isEmpty()){
            return new ResponseEntity<List<Buses>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Buses>>(busesList,HttpStatus.OK);
        }
    }
    //tim kiem theo khoang cach quang duong
    @GetMapping(value = "/find-by-distance/{d}")
    public ResponseEntity<Buses> findByDistance(@PathVariable Long d ) {
        Optional<Buses> buses = busesService.findByDistance(d);
        Buses buses1 = buses.get();
        if (buses1 == null) {
            return new ResponseEntity<Buses>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Buses>(buses1, HttpStatus.OK);
        }
    }
}
