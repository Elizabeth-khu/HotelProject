package com.example.demo.controllers;

import com.example.demo.models.Room;
import com.example.demo.services.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }
    @GetMapping(params = "roomNumber")
    public Room getRoomByNumber(@PathVariable Long roomNumber) {
        return roomService.getRoomByNumber(String.valueOf(roomNumber));
    }
    @GetMapping(params = "roomCapacity")
    public List<Room> getRoomByCapacity(@PathVariable Long roomCapacity) {
        return roomService.getRoomByCapacity(String.valueOf(roomCapacity));
    }

    @PostMapping()
    public Room addRoom(@RequestBody @Valid Room room) {
        return roomService.addRoom(room);
    }
}
