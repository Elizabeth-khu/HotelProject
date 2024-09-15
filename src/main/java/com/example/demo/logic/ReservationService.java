package com.example.demo.logic;
import com.example.demo.controllers.CheckInController;
import com.example.demo.models.CheckIn;
import com.example.demo.models.Room;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

//class in logic
public class ReservationHandler {
    private String start_date;
    private String end_date;
    private List<Date> handled_dates = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    private CheckInController checkInController = new CheckInController();
    public ReservationHandler(int start_date, int end_date) {
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
        List<CheckIn> candidates = checkInController.getRoomForReservation(date_start1);
        //QUERIE: SELECT * FROM rooms WHERE end_date>date_start1 AND capacity=capacity
        for (CheckIn checkIn : candidates) {
            Date date_start2 = formatter.parse(checkIn.getStartDate());        //from table
            if ( date_start2.before(date_end1) ) continue;
            return checkIn.getRoom();
        }
        return null;                //if every room is not free, return huitu
    }
}