package io.github.vinilopes1.users.model.repository;

import io.github.vinilopes1.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
