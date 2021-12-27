package br.com.meli.demo.dtos;

import br.com.meli.demo.entities.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
    private String name;
    private double width;
    private double length;

    public static Room toEntity(RoomDTO dto) {
        Room room = new Room();

        room.setName(dto.getName());
        room.setWidth(dto.getWidth());
        room.setLength(dto.getLength());

        return room;
    }

    public static RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setName(room.getName());
        roomDTO.setWidth(room.getWidth());
        roomDTO.setLength(room.getLength());

        return roomDTO;
    }
}
