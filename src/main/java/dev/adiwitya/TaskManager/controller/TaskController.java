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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.adiwitya.TaskManager.entity.Task;
import dev.adiwitya.TaskManager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api")
@Tag(name="Task Manager",description = "Task manager end points")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Operation(summary = "creating new Taks")
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		
		return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
	}
	@Operation(summary = "List of taks")
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getTaskList(){
		return ResponseEntity.ok(taskService.getAllTask());
	}
	@Operation(summary = "Delete task using task_id")
	@DeleteMapping("/tasks/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable long taskId){
		taskService.deleteTask(taskId);
		return ResponseEntity.ok("Deleted Successfully");
	}
	@Operation(summary = "Update task using task_id")
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Task>updateTask(@RequestBody Task task,@PathVariable long taskId){
		return ResponseEntity.ok(taskService.updateTask(taskId, task));
	}
	@Operation(summary = "find task using task_id")
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable long taskId){
		return ResponseEntity.ok(taskService.getTaskById(taskId));
	}
	@Operation(summary = "change task status like completed,inprogress,pendding etc task using task_id")
	@PatchMapping("/tasks/{taskId}")
	public ResponseEntity<String> updateTaskStatus(@PathVariable long taskId,@RequestParam String status){
		taskService.markAsCompleted(taskId, status);
		return ResponseEntity.ok("Successfully update ");
	}

}
