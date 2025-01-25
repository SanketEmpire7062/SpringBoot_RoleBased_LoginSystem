package com.empire.SpringBootRoleBasedAuthentication.repository;

import com.empire.SpringBootRoleBasedAuthentication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
