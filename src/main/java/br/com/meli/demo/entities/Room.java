package br.com.meli.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Room {
    private String name;
    private double width;
    private double length;

    public double getArea() {
        return this.width * this.length;
    }
}
