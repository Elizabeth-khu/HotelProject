package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    private int number;
    @Getter
    private int capacity;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private final List<CheckIn> checkIns = new ArrayList<>();

    public Room() {

    }
    public Room(int id, int number, int capacity) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
