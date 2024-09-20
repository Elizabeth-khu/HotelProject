package com.example.demo.controllers;

import com.example.demo.models.Room;
import com.example.demo.services.RoomService;
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
    public Room getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }
    @GetMapping(params = "roomNumber")
    public Room getRoomByNumber(@PathVariable int roomNumber) {
        return roomService.getRoomByNumber(roomNumber);
    }
    @GetMapping(params = "roomCapacity")
    public List<Room> getRoomByCapacity(@PathVariable int roomCapacity) {
        return roomService.getRoomByCapacity(roomCapacity);
    }

    @PostMapping(params = "roomNumber")
    public boolean reserve(@PathVariable int id) {
        return roomService.reserve(id);
    }

    @PostMapping(params = "id")
    public boolean payForRoom(@PathVariable int id) {
        return roomService.pay(id);
    }

    //@PostMapping()
    //public Room addRoom(@RequestBody @Valid Room room) {
    //    return roomService.addRoom(room);
    //}
}
