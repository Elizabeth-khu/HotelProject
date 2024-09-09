package com.example.demo.repositories;

import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    <S extends Room> S save(@Nullable S room);

    Optional<Object> findByNumber(String roomNumber);

    Optional<Object> findByCapacity(String roomCapacity);

}