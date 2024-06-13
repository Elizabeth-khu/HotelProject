package com.example.demo.controllers;

import com.uj.demo.demo.models.Event;
import com.uj.demo.demo.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping(params = "coachId")
    public List<Event> getEventsByCoachId(@RequestParam Long coachId) {
        return eventService.getEventsByCoachId(coachId);
    }

    @GetMapping(params = "clubId")
    public List<Event> getEventsByClubId(@RequestParam Long clubId) {
        return eventService.getEventsByClubId(clubId);
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }
}
