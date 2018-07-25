package services;

import java.util.List;

import dtos.UserDTO;
import exceptions.BusinessLogicException;
import tools.Role;

public interface UserService {

	void registerUser(String userName, String password, String confirmPassword, Role role) throws BusinessLogicException;
	
	List<UserDTO> extractUsers() throws BusinessLogicException;
}
