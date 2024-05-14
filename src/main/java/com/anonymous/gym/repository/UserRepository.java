package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.User;
import com.anonymous.gym.model.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
