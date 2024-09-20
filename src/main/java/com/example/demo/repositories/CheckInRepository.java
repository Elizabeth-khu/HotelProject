package com.example.demo.repositories;

import com.example.demo.models.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
    //delete
    List<CheckIn> findByClientId(int clientId);

    List<CheckIn> findByRoomId(int clubId);

    <S extends CheckIn> S save(@Nullable S checkIn);
    @Query("SELECT * FROM rooms WHERE end_date>date_start1 AND capacity=capacity")      //dodelat
    List<CheckIn> getRoomForReservation(Date date_start1, int capacity);
}
