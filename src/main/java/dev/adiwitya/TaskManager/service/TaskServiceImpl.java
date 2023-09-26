package dev.adiwitya.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adiwitya.TaskManager.entity.Task;
import dev.adiwitya.TaskManager.repositrory.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	@Override
	public Task createTask(Task task) {
		
		return taskRepo.save(task);
	}

	@Override
	public void deleteTask(long id) {
		taskRepo.delete(id);

	}

	@Override
	public List<Task> getAllTask() {
		
		return taskRepo.findAll();
	}

	@Override
	public Task updateTask(long taskId, Task task) {
		// TODO Auto-generated method stub
		return taskRepo.update(taskId, task);
	}

	@Override
	public Task getTaskById(long taskId) {
		// TODO Auto-generated method stub
		return taskRepo.findById(taskId);
	}

}
