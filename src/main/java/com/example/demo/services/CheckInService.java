package com.example.demo.services;

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
                .orElseThrow(() -> new IllegalArgumentException("Event not found with id: " + id));
    }

    public List<CheckIn> getCheckInByClientId(Long coachId) {
        return checkInRepository.findByClientId(coachId);
    }

    public List<CheckIn> getCheckInByClubId(Long clubId) {
        return checkInRepository.findByRoomId(clubId);
    }

    public CheckIn addCheckIn(CheckIn event) {
        return checkInRepository.save(event);
    }
}
