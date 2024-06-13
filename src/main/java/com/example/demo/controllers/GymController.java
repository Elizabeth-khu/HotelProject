package com.example.demo.controllers;

import com.example.demo.models.Room;
import com.example.demo.services.GymService;
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
    public List<Room> getAllRooms() {
        return gymService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return gymService.getRoomById(id);
    }

    @PostMapping()
    public Room addGym(@RequestBody @Valid Room room) {
        System.out.println("Terminator: i need your clothes and bike.");
        return gymService.addGym(room);
    }
}
