package br.com.meli.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.meli.demo.entities.House;

@Component
public class HouseRepository {
    private List<House> houses = new ArrayList<>();

    public House save(House house) {
        house.setId(houses.size() + 1);

        houses.add(house);

        return house;
    }

    public House getByName(String name) {
        return houses
                .stream()
                .filter(house -> house.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(new House());
    }
}
