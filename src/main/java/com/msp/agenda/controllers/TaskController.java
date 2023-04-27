package com.msp.agenda.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.msp.agenda.models.Task;
import com.msp.agenda.services.TaskServices;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

	@Autowired
	private TaskServices  taskServices; 
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id){
		Task obj = taskServices.findById(id);
		return ResponseEntity.ok().body(obj);
	
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Task>> findAllByUserId(@PathVariable Long userId){
		List<Task> objs = taskServices.findAllByUserId(userId);
		return ResponseEntity.ok().body(objs);
	}
	
	@PostMapping
	@Validated
	public ResponseEntity<Void> create(@Valid @RequestBody Task  task){
		taskServices.create(task);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id").buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	@Validated
	public ResponseEntity<Task> update(@Valid @RequestBody Task task, @PathVariable Long id){
		taskServices.update(task);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		taskServices.delete(id);
		return ResponseEntity.noContent().build();
	}
}




















