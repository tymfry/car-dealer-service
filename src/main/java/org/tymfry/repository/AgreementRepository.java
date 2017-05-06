package org.tymfry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tymfry.entity.Agreement;

public interface AgreementRepository extends JpaRepository<Agreement, Integer>{

}
