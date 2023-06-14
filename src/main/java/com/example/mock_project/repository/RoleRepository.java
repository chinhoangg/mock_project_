package com.example.mock_project.repository;

import com.example.mock_project.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Admin
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
