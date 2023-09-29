package dev.adiwitya.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adiwitya.TaskManager.Exception.ResourceNotFoundException;
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
		
		Task tsk =taskRepo.findById(id);
		if(tsk==null) throw new ResourceNotFoundException("task Not found", "taskId ", id);
		taskRepo.delete(tsk);

	}

	@Override
	public List<Task> getAllTask() {
		
		return taskRepo.findAll();
	}

	@Override
	public Task updateTask(long taskId, Task task)  {
		Task tsk=taskRepo.findById(taskId);
		if(tsk==null ) throw new ResourceNotFoundException("task Not found", "TaskId ", taskId);
		
		return taskRepo.update( tsk);
	}

	@Override
	public Task getTaskById(long taskId) {
		Task tsk=taskRepo.findById(taskId);
		if(tsk==null) throw new ResourceNotFoundException("task Not found", "TaskId ", taskId);
		return taskRepo.findById(taskId);
	}

	@Override
	public void markAsCompleted(long id,String status) {
		Task tsk= taskRepo.findById(id);
		if(tsk==null) throw new ResourceNotFoundException("task Not found", "taskId ", id);
		tsk.setStatus(status);
		taskRepo.updateStatus(tsk);
	}
	

}
