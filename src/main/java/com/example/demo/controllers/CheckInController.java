package com.example.demo.controllers;

import com.example.demo.models.CheckIn;
import com.example.demo.services.CheckInService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkIn")
public class CheckInController {
    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @GetMapping
    public List<CheckIn> getAllCheckIn() {
        return checkInService.getAllCheckIn();
    }

    @GetMapping("/{id}")
    public CheckIn getCheckInById(@PathVariable Long id) {
        return checkInService.getCheckInById(id);
    }

    @GetMapping(params = "clientId")
    public List<CheckIn> getEventsByClientId(@RequestParam Long clientId) {
        return checkInService.getCheckInByClientId(clientId);
    }

    @GetMapping(params = "clubId")
    public List<CheckIn> getCheckInByClubId(@RequestParam Long roomId) {
        return checkInService.getCheckInByClubId(roomId);
    }

    @PostMapping
    public CheckIn addCheckIn(@RequestBody CheckIn checkIn) {
        return checkInService.addCheckIn(checkIn);
    }
}
