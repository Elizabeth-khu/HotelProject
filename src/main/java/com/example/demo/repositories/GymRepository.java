package com.example.demo.repositories;

import com.uj.demo.demo.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface GymRepository extends JpaRepository<Club, Long> {
    <S extends Club> S save(@Nullable S coach);
}