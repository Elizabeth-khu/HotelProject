package com.example.demo.services;

import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + id));
    }

    public Room getRoomByNumber(int roomNumber) {
        return (Room) roomRepository.findByNumber(roomNumber)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with number: " + roomNumber));
    }

    public List<Room> getRoomByCapacity(int roomCapacity) {
        return (List<Room>) roomRepository.findByCapacity(roomCapacity)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with capacity: " + roomCapacity));
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public boolean reserve(int id) {
        Room foundRoom = roomRepository.findNotReservedById(id);
        if (foundRoom.isPresent()) {
            foundRoom.setReserve(true);
            roomRepository.save(foundRoom);
            return true;
        }
        return false;
    }

    public boolean pay(int id) {
        Room foundRoom = roomRepository.findNotReservedById(id);
        if (foundRoom.isPresent()) {

            Room room = foundRoom.get();
            room.setPaid(true);
            roomRepository.save(foundRoom);
            return true;
        }
        return false;
    }
}
