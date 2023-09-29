package dev.adiwitya.TaskManager.repositrory;

import java.util.List;

import dev.adiwitya.TaskManager.entity.Task;

public interface JdbcRepository {
	
	Task save(Task task);
	List<Task> findAll();
	Task findById(long taskId);
	Task update(Task task);
	void delete(Task task);
	void updateStatus(Task task);
	
	

}
