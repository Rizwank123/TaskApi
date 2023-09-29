package dev.adiwitya.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.adiwitya.TaskManager.Exception.ResourceNotFoundException;
import dev.adiwitya.TaskManager.Security.JwtService;
import dev.adiwitya.TaskManager.dto.LoginRequest;
import dev.adiwitya.TaskManager.entity.UserInfo;
import dev.adiwitya.TaskManager.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
    private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new ResponseEntity<UserInfo>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/Users")
	public ResponseEntity<List<UserInfo>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@PostMapping("/getToken")
    public String authenticateAndGetToken(@RequestBody LoginRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
            throw new ResourceNotFoundException("invalid user request","",0);
        }


    }

}
