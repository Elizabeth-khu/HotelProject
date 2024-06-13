package com.example.demo.controllers;

import com.uj.demo.demo.models.Club;
import com.uj.demo.demo.services.GymService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/gyms")
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return gymService.getAllClubs();
    }

    @GetMapping("/{id}")
    public Club getClubById(@PathVariable Long id) {
        return gymService.getClubById(id);
    }

    @PostMapping()
    public Club addGym(@RequestBody @Valid Club club) {
        System.out.println("Terminator: i need your clothes and bike.");
        return gymService.addGym(club);
    }
}
