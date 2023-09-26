package dev.adiwitya.TaskManager.payload;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.adiwitya.TaskManager.entity.Priority;
import dev.adiwitya.TaskManager.entity.Task;

public class TaskRowMapper implements RowMapper<Task> {

	
        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Task(
                rs.getLong("task_id"),
                rs.getString("name"),
                rs.getString("description"),
                Priority.valueOf(rs.getString("priority")),
                rs.getTimestamp("due_date")
            );
        }
    
}


