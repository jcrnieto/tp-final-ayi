package com.ayi.tp.rest.serv.app.repository;

import com.ayi.tp.rest.serv.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
