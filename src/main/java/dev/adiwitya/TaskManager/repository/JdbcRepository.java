package dev.adiwitya.TaskManager.repository;

import java.util.List;

import dev.adiwitya.TaskManager.entity.Task;

public interface JdbcRepository {
	
	Task save(Task task);
	List<Task> findAll();
	Task findById(long taskId);
	Task update(long id,Task task);
	void delete(long taskId);
	
	

}
