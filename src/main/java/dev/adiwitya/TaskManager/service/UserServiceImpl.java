package dev.adiwitya.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adiwitya.TaskManager.entity.UserInfo;
import dev.adiwitya.TaskManager.repositrory.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserInfo createUser(UserInfo user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<UserInfo> getAllUser() {
		
		return userRepository.findAll();
	}

}
