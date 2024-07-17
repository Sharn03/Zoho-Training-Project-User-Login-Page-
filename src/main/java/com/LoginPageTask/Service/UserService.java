package com.LoginPageTask.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.LoginPageTask.Entity.User;
import com.LoginPageTask.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUser()
	{
		List<User> employeeList = userRepo.findAll();
		return employeeList;
	}
	
	public User getUserByEmailId(String mailId)
	{
		User user = userRepo.findByEmailId(mailId);
		return user;
	}
	
	
	public User getUserById(int id)
	{
		//Declaring the employee obj to null 
		User user = null;
		
		// checking if the id is null or not
		if(Objects.nonNull(id))
		{
		 // here we are using Optional class to check where the object is present or not 
		 Optional<User> optionalUser = userRepo.findById(id);
		 
		 if(optionalUser.isPresent())
		 {
			 user = optionalUser.get();
		 }
		
		 else
		 {
			throw new RuntimeException("User id "+ id +" Not Found ");
		 }
		 
		}
		 
		 return user;
	}
	
	public void saveUser(User user)
	{
		//checking the arguments is null or not
		if(Objects.nonNull(user))
		{
			
		 userRepo.save(user);
		
		}
	}
	
	
}
