package com.example.demo.logic;

import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class DefaultHotel {

    @Autowired
    private RoomRepository roomRepository;

    public ArrayList<Room> generateRooms(){
        ArrayList<Room> hotel = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++) {
                Room room = new Room(j*10+i,j*10+i, j);
                hotel.add(room);
                roomRepository.save(room);
            }
        }
        return hotel;
    }

}
