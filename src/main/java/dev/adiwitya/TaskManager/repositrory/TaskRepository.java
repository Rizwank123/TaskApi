package dev.adiwitya.TaskManager.repositrory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.adiwitya.TaskManager.entity.Task;
import dev.adiwitya.TaskManager.payload.TaskMapper;

import org.springframework.jdbc.support.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TaskRepository implements JdbcRepository {

	private static final String INSERT_QUERY = "INSERT INTO task (name, description, priority, due_date,status) VALUES (?, ?, ?, ?,?) RETURNING task_id";
	private static final String DELETE_QUERY = "DELETE FROM task WHERE task_id=?";
	private static final String TASK_BY_ID_QUERY = "SELECT * FROM task WHERE task_id=? ";
	private static final String UPDATE_QUERY = "UPDATE task SET description = ?, priority = ?, due_date = ? WHERE task_id = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM task";
	private  static final String updateStatus_query="update task set status=? where task_id=? ";

	TaskMapper taskRow = new TaskMapper();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Task save(Task task) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, task.getName());
			ps.setString(2, task.getDescription());
			ps.setString(3, task.getPriority().name());
			ps.setTimestamp(4, task.getDueDate());
			ps.setString(5, task.getStatus());
			return ps;
		}, keyHolder);
		Number genratedId = keyHolder.getKey();

		if (genratedId != null)
			task.setTaskId(genratedId.longValue()); // Set the generated ID in the task object
		else
			throw new IllegalStateException("not generated Id found");
		return task;
	}

	@Override
	public List<Task> findAll() {
		return jdbcTemplate.query(SELECT_ALL_QUERY, new TaskMapper());
	}

	@Override
	public Task findById(long taskId) {
		try {
			return jdbcTemplate.queryForObject(TASK_BY_ID_QUERY, new Object[] { taskId }, taskRow);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// Handle the case where no task with the given ID was found
			return null;
		}
	}

	@Override
	public Task update( Task task) {
		jdbcTemplate.update(UPDATE_QUERY, task.getDescription(), task.getPriority().name(), task.getDueDate(), task.getTaskId());
		task.setTaskId(task.getTaskId());
		return task;
	}

	@Override
	public void delete(Task task) {
		jdbcTemplate.update(DELETE_QUERY, task.getTaskId());
	}
	@Override
	public void updateStatus(Task task) {
		jdbcTemplate.update(updateStatus_query,task.getStatus(),task.getTaskId());
		
	}

}