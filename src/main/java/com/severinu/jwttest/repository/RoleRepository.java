package com.severinu.jwttest.repository;

import com.severinu.jwttest.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>  {

    Role findByName(String userName);
}
