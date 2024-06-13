package com.example.demo.controllers;

import com.example.demo.models.Coach;

import com.example.demo.services.CoachService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class ClientController {
    private final CoachService coachService;

    public ClientController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id);
    }

    @PostMapping
    public Coach addCoach(@RequestBody Coach coach) {
        return coachService.addCoach(coach);
    }
}
