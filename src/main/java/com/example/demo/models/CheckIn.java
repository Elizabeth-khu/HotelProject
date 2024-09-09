package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stayingPeriod;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    public CheckIn() {}
    public CheckIn(Long id, Client client, Room room, String stayingPeriod) {
        this.id = id;
        this.client = client;
        this.room = room;
        this.stayingPeriod = stayingPeriod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStayingPeriod(String stayingPeriod) {
        this.stayingPeriod = stayingPeriod;
    }
}
