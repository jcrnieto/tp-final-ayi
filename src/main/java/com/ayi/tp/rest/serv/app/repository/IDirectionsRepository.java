package com.ayi.tp.rest.serv.app.repository;

import com.ayi.tp.rest.serv.app.entity.Directions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDirectionsRepository extends JpaRepository<Directions, Long> {
}
