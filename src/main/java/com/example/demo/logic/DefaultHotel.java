package com.example.demo.logic;

import com.example.demo.models.Room;

import java.util.*;

public class DefaultHotel {

    ArrayList<Room> hotel = generateRooms();

    private ArrayList<Room> generateRooms(){
        ArrayList<Room> hotel = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++) {
                Room room = new Room(j*10+i,j*10+i, j);
                hotel.add(room);
            }
        }
        return hotel;
    }

    //create default rooms
    //lista par {capacity,number}. 10 rooms for each capacity - 1,2,3,4

    //RoomController - addRoom

}
