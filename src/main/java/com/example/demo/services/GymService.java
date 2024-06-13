package com.example.demo.services;

import com.uj.demo.demo.models.Club;
import com.uj.demo.demo.repositories.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    private final GymRepository gymRepository;

    public GymService(GymRepository clubRepository) {
        this.gymRepository = clubRepository;
    }

    public List<Club> getAllClubs() {
        return gymRepository.findAll();
    }

    public Club getClubById(Long id) {
        return gymRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club not found with id: " + id));
    }

    public Club addGym(Club club) {
        return gymRepository.save(club);
    }
}
