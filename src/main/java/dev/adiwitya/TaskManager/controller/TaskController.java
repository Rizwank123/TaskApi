package dev.adiwitya.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.adiwitya.TaskManager.entity.Task;
import dev.adiwitya.TaskManager.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		
		return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
	}
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getTaskList(){
		return ResponseEntity.ok(taskService.getAllTask());
	}
	@DeleteMapping("/tasks/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable long taskId){
		taskService.deleteTask(taskId);
		return ResponseEntity.ok("Deleted Successfully");
	}
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Task>updateTask(@RequestBody Task task,@PathVariable long taskId){
		return ResponseEntity.ok(taskService.updateTask(taskId, task));
	}
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable long taskId){
		return ResponseEntity.ok(taskService.getTaskById(taskId));
	}

}
