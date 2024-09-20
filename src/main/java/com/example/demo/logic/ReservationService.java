package com.example.demo.logic;
import com.example.demo.models.CheckIn;
import com.example.demo.models.Room;
import com.example.demo.repositories.CheckInRepository;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

@Service
public class ReservationService {
    private String start_date;
    private String end_date;
    private List<Date> handled_dates = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    @Autowired
    private CheckInRepository checkInRepository;
    @Autowired
    private RoomRepository roomRepository;
    public ReservationService(int start_date, int end_date) {
        this.start_date = String.valueOf(start_date);
        this.end_date = String.valueOf(end_date);
    }
    public void handleDates() {
        this.start_date = new StringBuilder(start_date)
                .insert(start_date.length()-4,"-")
                .insert(start_date.length()-6,"-")
                .toString();
        this.end_date = new StringBuilder(end_date)
                .insert(end_date.length()-4,"-")
                .insert(end_date.length()-6,"-")
                .toString();
        try {
            parseDates();
        } catch (ParseException e) {
            wrongDate();
        }
    }
    private void parseDates() throws ParseException {
        Date start = formatter.parse(start_date);
        Date end = formatter.parse(end_date);
        handled_dates.add(start);
        handled_dates.add(end);
    }
    private void wrongDate() {}

    public Room findFreeRoom(int capacity) {
        Date date_start1 = handled_dates.get(0);                            //from input
        Date date_end1 = handled_dates.get(1);                              //from input
        List<CheckIn> candidates = checkInRepository.getRoomForReservation(date_start1, capacity);          //beret tolko iz checkIna; jesli checkIna na komnatu nie bylo, to ona nie budet najdziena
        for (CheckIn checkIn : candidates) {
            Date date_start2 = checkIn.getStartDate();        //from table
            if ( date_start2.before(date_end1) ) continue;
            return checkIn.getRoom();
        }
        return null;                //if every room is not free, return huitu
    }
}