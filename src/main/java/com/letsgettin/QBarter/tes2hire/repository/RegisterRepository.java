package com.letsgettin.QBarter.tes2hire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letsgettin.QBarter.tes2hire.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    
    Optional<Register> findByEmailId(String emailId);
  
    Register findById(long id);

	boolean existsByEmailId(String emailId);

}