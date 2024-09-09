package com.example.demo.repositories;

import com.example.demo.models.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
    //delete
    List<CheckIn> findByClientId(int clientId);

    List<CheckIn> findByRoomId(int clubId);

    <S extends CheckIn> S save(@Nullable S coach);
}
