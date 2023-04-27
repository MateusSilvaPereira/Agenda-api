package com.msp.agenda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msp.agenda.models.User;
import com.msp.agenda.respository.TaskRepository;
import com.msp.agenda.respository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(()-> 
		new RuntimeException("Usuario não encontrado: id =" + id + " Tipo = " + User.class.getName()));
	}
	
	@Transactional
	public User create(User obj) {
		obj.setId(null);
		obj = userRepository.save(obj);
		return obj;
	}
	
	@Transactional
	public User update(User obj) {
		User newObj = findById(obj.getId());
		newObj.setPassword(obj.getPassword());
		return userRepository.save(newObj);
	}
	
	public void delete(Long id) {
		
		findById(id);
		
		try {
			
			userRepository.deleteById(id);	
		} catch (Exception e) {
			
			throw new RuntimeException("Não é possivel excluir pois há entidades relacionadas!");			
		}
	}
}













