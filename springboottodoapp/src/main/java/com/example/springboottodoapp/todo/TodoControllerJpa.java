package com.example.springboottodoapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	private TodoService todoService;
	private TodoRepository todorepository;

	public TodoControllerJpa(TodoService todoService, TodoRepository todorepository) {
		super();
		this.todoService = todoService;
		this.todorepository = todorepository;
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap modelmap) {
		String username = getLoggedInUsername();
		List<Todo> todos = todorepository.findByUsername(username);
		modelmap.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@GetMapping("add-todo")
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@PostMapping("add-todo")
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		String username = getLoggedInUsername();
		todo.setUsername(username);
		
		System.out.println(todo.toString());
		
		if (result.hasErrors()) {
			return "todo";
		}
		todorepository.save(todo);
		
//		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
//		todoService.deleteById(id);
		todorepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@GetMapping("update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
//		Todo todo = todoService.findById(id);
		Optional<Todo> todo = todorepository.findById(id);
		
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@PostMapping("update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		String username = getLoggedInUsername();
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUsername(username);
		todorepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
