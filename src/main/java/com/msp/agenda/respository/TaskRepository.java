package com.msp.agenda.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msp.agenda.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser_id(Long id);
	
	// Query utilizando JPQL 
	
	/*@Query(value ="SELECT t FROM Task t WHERE t.user.id = : id")
	List<Task> findByUser_id(@Param("id") Long id); */
	
	
	// Query utilizando SQL Nativo
	
	/*@Query(value = "SELECT * FROM task t WHERE t.user_id = : id ",nativeQuery = true)
	List<Task> findByUser_id(@Param("id") Long id);*/
}
