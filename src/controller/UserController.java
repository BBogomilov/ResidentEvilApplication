package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dtos.UserDTO;
import services.UserService;
import tools.Role;

@RestController
@RequestMapping(path = "/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	

	@PostMapping(value = "/register", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void registerUser(final String userName, final String password, final String confirmPassword, final Role role) {
			userService.registerUser(userName, password, confirmPassword, role);
	}
	
	@GetMapping(value = "/getAll", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserDTO> extractUsers() {
			return userService.extractUsers();
	}
}
