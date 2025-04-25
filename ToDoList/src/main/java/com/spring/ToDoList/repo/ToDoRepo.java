package com.spring.ToDoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ToDoList.ToDo;

public interface ToDoRepo extends JpaRepository<ToDo, Long>{
	ToDo findByCompleted(boolean completed);

}
