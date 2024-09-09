package com.example.demo.repositories;

import com.example.demo.models.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    //delete
    List<CheckIn> findByClientId(Long clientId);

    List<CheckIn> findByRoomId(Long clubId);

    <S extends CheckIn> S save(@Nullable S coach);
}
