package dev.adiwitya.TaskManager.service;

import java.util.List;

import dev.adiwitya.TaskManager.entity.UserInfo;

public interface UserService {
	
	UserInfo createUser(UserInfo user);
	List<UserInfo> getAllUser();

}
