package com.msp.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msp.agenda.models.Task;
import com.msp.agenda.models.User;
import com.msp.agenda.respository.TaskRepository;

@Service
public class TaskServices {

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public Task findById(Long id) {
		
		Optional<Task> task = taskRepository.findById(id);
		return task.orElseThrow(()-> new RuntimeException(
				"Tarefa não encontrada!: id = " + id + " Tipo = " + Task.class.getName()));
	}
	
	public List<Task> findAllByUserId(Long userId){
		List<Task> task = taskRepository.findByUser_id(userId);
		return task;
	}
	
	@Transactional
	public Task create(Task obj) {
		User user = userServices.findById(obj.getUser().getId());
		obj.setId(null);
		obj.setUser(user);
		obj = taskRepository.save(obj);
		return obj;
	}
	
	@Transactional
	public Task update(Task obj) {
		Task task = findById(obj.getId());
		task.setDescription(obj.getDescription());
		task = taskRepository.save(task);
		return task;
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			taskRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException(
					"Não é possivel excluir pois há entidades relacionadas!"
					);
		}
	}
}














