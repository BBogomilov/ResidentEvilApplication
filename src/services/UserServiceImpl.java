package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtos.UserDTO;
import entities.User;
import exceptions.BusinessLogicException;
import repository.UserRepository;
import tools.Role;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void registerUser(String userName, String password, String confirmPassword, Role role) throws BusinessLogicException{
		try
			{
			if(!userRepository.existUser(userName))
			{
				throw new BusinessLogicException("A user with this name already exists");
			}
			
			if(!password.equals(confirmPassword))
			{
				throw new BusinessLogicException("Passwords don't match");
			}
			User user = new User(userName, role);
			userRepository.save(user);

			}	catch(Exception e)
		{
			throw new BusinessLogicException(e.getMessage());
		}
	}


	@Override
	public List<UserDTO> extractUsers() throws BusinessLogicException {
		try
			{
			List<User> users = userRepository.listAllOrderByName();
			List<UserDTO> userDtos = new ArrayList<>();
			users.stream().forEach(u -> userDtos.add(new UserDTO(u.getName(), u.getRole())));
			return userDtos;
			}	catch(Exception e)
		{
			throw new BusinessLogicException(e.getMessage());
		}
	}

}
