package com.example.demo.services;

import com.example.demo.models.Room;
import com.example.demo.repositories.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    private final GymRepository gymRepository;

    public GymService(GymRepository roomRepository) {
        this.gymRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return gymRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return gymRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club not found with id: " + id));
    }

    public Room addGym(Room room) {
        return gymRepository.save(room);
    }
}
