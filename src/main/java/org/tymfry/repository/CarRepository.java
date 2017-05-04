package org.tymfry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tymfry.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
