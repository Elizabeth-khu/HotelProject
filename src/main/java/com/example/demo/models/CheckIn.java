package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date start_date;
    private Date end_date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    public CheckIn() {}
    public CheckIn(Long id, Client client, Room room, Date start_date, Date end_date) {
        this.id = id;
        this.client = client;
        this.room = room;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStartDate() { return start_date; }
    public Date getEndDate() { return end_date; }

    public Room getRoom() {
        return room;
    }
}
