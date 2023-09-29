package dev.adiwitya.TaskManager.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor

public class ApiResponse {
	private String message;
	boolean success;

}
