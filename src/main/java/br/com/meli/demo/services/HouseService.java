package br.com.meli.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.demo.dtos.HouseDTO;
import br.com.meli.demo.entities.House;
import br.com.meli.demo.entities.Room;
import br.com.meli.demo.repositories.HouseRepository;

@Service
public class HouseService {

    @Autowired
    private HouseRepository repository;

    public House save(HouseDTO dto) {
        return repository.save(HouseDTO.toEntity(dto));
    }

    public Double showTotalArea(String houseName) {
        Double totalArea = 0.0;

        House house = repository.getByName(houseName);

        totalArea = house.getRooms()
                .stream()
                .mapToDouble(Room::getArea)
                .sum();

        return totalArea;
    }

    public Double showTotalPrice(String houseName) {
        Double totalPrice = showTotalArea(houseName) * 800;

        return totalPrice;
    }

    public Room getHighestRoom(String houseName) {
        double highArea = 0.0;
        Room highestRoom = new Room();

        House house = repository.getByName(houseName);

        for (int i = 0; i < house.getRooms().size(); i++) {
            if (house.getRooms().get(i).getArea() > highArea) {
                highArea = house.getRooms().get(i).getArea();
                
                highestRoom = house.getRooms().get(i);
            }
        }

        return highestRoom;
    }

    public List<Room> showRoomsArea(String houseName) {
        House house = repository.getByName(houseName);

        return house.getRooms();
    }
}
