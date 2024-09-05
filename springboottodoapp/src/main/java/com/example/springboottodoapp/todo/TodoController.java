package com.example.springboottodoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

// @Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap modelmap) {
		String username = getLoggedInUsername();
		List<Todo> todos = todoService.findByUsername(username);
		modelmap.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		String username = getLoggedInUsername();
		if (result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@GetMapping("update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@PostMapping("update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		String username = getLoggedInUsername();
		if (result.hasErrors()) {
			return "todo";
		}
		
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
