package dev.adiwitya.TaskManager.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {

	private long taskId;
	private String name;
	private String description;
	private Priority priority;
	private String status;
	@JsonFormat(pattern = "dd/MM/yyyy h:MM a")
	Date dueDate;
	public Task(String name, String description, String priority,Date dueDate,String status) {
		super();
		this.name = name;
		this.description = description;
		if (priority != null || !priority.isEmpty()) {
	        try {
	            this.priority = Priority.valueOf(priority);
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Invalid priority: " + priority);
	        }
	    } else {
	        // Handle the case where priority is null
	        throw new IllegalArgumentException("Priority cannot be null");
	    }
		this.dueDate = dueDate;
		this.status=status;
	}
	public Task(long taskId, String name, String description, Priority priority, Date timestamp,String status) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.dueDate = timestamp;
		this.status=status;
	}
	

}
