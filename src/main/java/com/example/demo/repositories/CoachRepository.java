package com.example.demo.repositories;

import com.uj.demo.demo.models.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    <S extends Coach> S save(@Nullable S coach);
}