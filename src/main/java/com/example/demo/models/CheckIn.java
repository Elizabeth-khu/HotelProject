package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client coach;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    public CheckIn() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoach(Client coach) {
        this.coach = coach;
    }

    public void setClub(Room club) {
        this.room = club;
    }

    public CheckIn(Long id, String name, Client coach, Room club) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.room = club;
    }
}
