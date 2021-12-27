package br.com.meli.demo.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.demo.entities.House;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseDTO {
    private long id;
    private String name;
    private String address;
    private List<RoomDTO> rooms;

    public static House toEntity(HouseDTO dto) {
        House house = new House();

        house.setName(dto.getName());
        house.setAddress(dto.getAddress());
        house.setRooms(dto.getRooms()
                .stream()
                .map(roomDTO -> RoomDTO.toEntity(roomDTO))
                .collect(Collectors.toList()));

        return house;
    }

    public static HouseDTO toDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();

        houseDTO.setId(house.getId());
        houseDTO.setName(house.getName());
        houseDTO.setAddress(house.getAddress());
        houseDTO.setRooms(house.getRooms()
                .stream()
                .map(room -> RoomDTO.toDTO(room))
                .collect(Collectors.toList()));

        return houseDTO;
    }
}
