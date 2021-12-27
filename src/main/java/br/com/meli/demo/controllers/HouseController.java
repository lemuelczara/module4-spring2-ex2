package br.com.meli.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.demo.dtos.HouseDTO;
import br.com.meli.demo.entities.Room;
import br.com.meli.demo.services.HouseService;

@RestController
@RequestMapping(path = "api/v1")
public class HouseController {

    @Autowired
    private HouseService service;

    @PostMapping(path = "/houses")
    public ResponseEntity<HouseDTO> save(@RequestBody HouseDTO dto) {
        return new ResponseEntity<>(HouseDTO.toDTO(service.save(dto)), HttpStatus.CREATED);
    }

    @GetMapping(path = "/houses/area/{houseName}")
    public ResponseEntity<Double> showTotalArea(@PathVariable String houseName) {
        return new ResponseEntity<>(service.showTotalArea(houseName), HttpStatus.OK);
    }

    @GetMapping(path = "/houses/value/{houseName}")
    public ResponseEntity<Double> showTotalPrice(@PathVariable String houseName) {
        return new ResponseEntity<>(service.showTotalPrice(houseName), HttpStatus.OK);
    }

    @GetMapping(path = "/houses/highestRoom/{houseName}")
    public ResponseEntity<Room> getHighestRoom(@PathVariable String houseName) {
        return new ResponseEntity<>(service.getHighestRoom(houseName), HttpStatus.OK);
    }

    @GetMapping(path = "/houses/roomsArea/{houseName}")
    public ResponseEntity<List<Room>> showRoomsArea(@PathVariable String houseName) {
        return new ResponseEntity<>(service.showRoomsArea(houseName), HttpStatus.OK);
    }
}
