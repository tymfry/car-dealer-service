package org.tymfry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tymfry.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
