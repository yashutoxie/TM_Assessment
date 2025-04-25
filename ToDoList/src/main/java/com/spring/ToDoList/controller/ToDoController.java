package com.spring.ToDoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ToDoList.ToDo;
import com.spring.ToDoList.repo.ToDoRepo;

@Controller
@RequestMapping("/todo")
public class ToDoController {
	@Autowired
	ToDoRepo toDoRepo;

	@PostMapping
	public ToDo insert(@RequestBody ToDo todo) {
		toDoRepo.save(todo);
		return todo;
	}

	@GetMapping
	public List<ToDo> getAllTodos() {
		return toDoRepo.findAll();
	}

}
