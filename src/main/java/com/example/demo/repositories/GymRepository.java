package com.example.demo.repositories;

import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface GymRepository extends JpaRepository<Room, Long> {
    <S extends Room> S save(@Nullable S room);
}