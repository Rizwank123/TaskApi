package dev.adiwitya.TaskManager.repositrory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.adiwitya.TaskManager.entity.UserInfo;
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByEmail(String username);
	

}
