package com.example.demo.services;

import com.uj.demo.demo.models.Event;
import com.uj.demo.demo.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found with id: " + id));
    }

    public List<Event> getEventsByCoachId(Long coachId) {
        return eventRepository.findByCoachId(coachId);
    }

    public List<Event> getEventsByClubId(Long clubId) {
        return eventRepository.findByClubId(clubId);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
}
