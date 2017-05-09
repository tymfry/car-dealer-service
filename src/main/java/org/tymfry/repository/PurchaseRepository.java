package org.tymfry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tymfry.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
