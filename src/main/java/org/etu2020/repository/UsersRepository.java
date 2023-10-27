package org.etu2020.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.etu2020.model.Users;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
	List<Users> findAll();
}