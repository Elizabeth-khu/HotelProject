package com.example.demo.repositories;

import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface ClientRepository extends JpaRepository<Client, Long> {
    <S extends Client> S save(@Nullable S client);
}