package dev.adiwitya.TaskManager.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import dev.adiwitya.TaskManager.Exception.ResourceNotFoundException;
import dev.adiwitya.TaskManager.entity.Task;
import dev.adiwitya.TaskManager.repositrory.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	@Override
	public Task createTask(Task task) {
		task.setDueDate(timeFormater(task.getDueDate()));
		
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
		if(task.getDescription()=="") tsk.setDescription(task.getDescription());
		else tsk.setDescription(tsk.getDescription());
		tsk.setDescription(task.getDescription());
		tsk.setDueDate(timeFormater(task.getDueDate()));
		if(task.getPriority().name()=="") tsk.setPriority(tsk.getPriority());
		else tsk.setPriority(task.getPriority());
		if(tsk.getName()=="") tsk.setName(tsk.getName());
		else tsk.setName(task.getName());
		
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
	private static Timestamp timeFormater(Timestamp timestamp) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        // Format the Timestamp as a String
	        String formattedTime = dateFormat.format(new Date(timestamp.getTime()));

	        try {
	            // Parse the formatted String back to a Date
	            Date parsedDate = dateFormat.parse(formattedTime);

	            // Create a new Timestamp from the parsed Date
	            return new Timestamp(parsedDate.getTime());
	        } catch (ParseException e) {
	            // Handle parsing exceptions here
	            e.printStackTrace();
	            return null;
	        }
	}
	

}
