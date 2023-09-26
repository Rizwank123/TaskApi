package dev.adiwitya.TaskManager.service;

import java.util.List;

import dev.adiwitya.TaskManager.entity.Task;

public interface TaskService {
	public Task createTask(Task task);
	public void deleteTask(long id);
	public List<Task> getAllTask();
	public Task updateTask(long taskId,Task task);
	public Task getTaskById(long taskId);

}
