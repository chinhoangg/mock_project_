package com.example.mock_project.repository;

import com.example.mock_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Adminf
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String username);

    User getUserById(int id);

    long count();

    User getUserByEmail(String email);

    User getUserById(Integer id);

    List<User> findAll();

    public User save(User user);
}
