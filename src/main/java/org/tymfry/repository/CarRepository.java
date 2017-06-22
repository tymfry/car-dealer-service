package org.tymfry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tymfry.entity.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	
	@Query("from Car c where c.id = :id")
	Car getCarById(@Param("id") int id);
	@Query("from Car c where c.vin = :vin")
	Car getCarByVin(@Param("vin") String vin);

}
