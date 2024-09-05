package com.example.springboottodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int counter_id = 0;
	
	static {
		todos.add(new Todo("Udemy", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo("Udemy", "Learn React", LocalDate.now().plusYears(1), false));
		todos.add(new Todo("Udemy", "Devops", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetdate, boolean done) {
		todos.add(new Todo(username, description, targetdate, true));
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(Todo todo) {
		this.deleteById(todo.getId());
		todos.add(todo);
	}
}
