package org.tymfry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tymfry.entity.Car;
import org.tymfry.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
	
	@Query("from Sale s where s.id = :id")
	Car getSaleById(@Param("id") int id);

}
