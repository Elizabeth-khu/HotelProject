package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String name;
    @Getter
    private String address;
    @Getter
    private String openingHours;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private final List<CheckIn> events = new ArrayList<>();

    public Room() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Room(Long id, String name, String address, String openingHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingHours = openingHours;
    }
}
