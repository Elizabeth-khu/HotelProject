package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String number;
    @Getter
    private String capacity;            //1,2,3 or 4. type=String, not int — сомнительно но окэй
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private final List<CheckIn> checkIns = new ArrayList<>();

    public Room() {

    }
    public Room(Long id, String number, String capacity) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
