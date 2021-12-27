package br.com.meli.demo.entities;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class House {
    private long id;
    private String name;
    private String address;
    private List<Room> rooms;
}
