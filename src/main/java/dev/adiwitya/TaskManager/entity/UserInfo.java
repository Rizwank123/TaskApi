package dev.adiwitya.TaskManager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String name;
    private String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private String roles;

}
