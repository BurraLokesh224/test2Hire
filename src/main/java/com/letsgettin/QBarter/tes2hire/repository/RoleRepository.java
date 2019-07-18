package com.letsgettin.QBarter.tes2hire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letsgettin.QBarter.tes2hire.model.Role;
import com.letsgettin.QBarter.tes2hire.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}