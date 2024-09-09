package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.CheckIn;
import com.example.demo.repositories.CheckInRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInService {
    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public List<CheckIn> getAllCheckIn() {
        return checkInRepository.findAll();
    }

    public CheckIn getCheckInById(Long id) {
        return checkInRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Check in not found with id: " + id));
    }

    /*public List<CheckIn> getCheckInByClientId(Long clientId) {
        return checkInRepository.findByClientId(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Check in not found with client id: " + clientId));
    }*/

   /* public List<CheckIn> getCheckInByRoomId(Long roomId) {
        return checkInRepository.findByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Check in not found with room id: " + roomId));
    }*/

    public CheckIn addCheckIn(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }
}
