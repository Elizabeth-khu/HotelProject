package com.example.demo.repositories;

import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    <S extends Room> S save(@Nullable S room);

    Optional<Object> findByNumber(int roomNumber);

    Optional<Object> findByCapacity(int roomCapacity);

    @Query("select")
    Room findNotReservedById(int id);

    void save(Optional<Room> foundRoom);

/*
@Query(select * from db where reserved = false)
    Optional<Room> findNotReservedById(int id);
}*/
}
