package com.example.demo.controllers;
import com.example.demo.logic.ReservationService;
import com.example.demo.models.CheckIn;
import com.example.demo.models.Room;
import com.example.demo.services.CheckInService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    }//breakpoint

    @GetMapping("/{id}")
    public CheckIn getCheckInById(@PathVariable int id) {
        return checkInService.getCheckInById(id);
    }

    @GetMapping(params = "clientId")
    public List<CheckIn> getEventsByClientId(@RequestParam int clientId) {
        return null;//checkInService.getCheckInByClientId(clientId);
    }

    @GetMapping(params = "roomId")
    public List<CheckIn> getCheckInByRoomId(@RequestParam int roomId) {
        return null;// checkInService.getCheckInByRoomId(roomId);
    }

    @PostMapping
    public CheckIn addCheckIn(@RequestBody CheckIn checkIn) {
        return checkInService.addCheckIn(checkIn);
    }

    //checkInController
    @PatchMapping(params = {"capacity","from","to"})
    public CheckIn reserveRoom(@RequestParam int capacity, @RequestParam int from, @RequestParam int to) {
        ReservationService reservationhandler = new ReservationService(from,to);
        reservationhandler.handleDates();
        Room room = reservationhandler.findFreeRoom(capacity);
        if ( room==null ) throw new RuntimeException();//throw new RoomNotFoundException; //deny();
        else {
            CheckIn checkIn = new CheckIn();
            //addCheckIn(room, dates_from_input);
        }
        return null;
    }
}
