package com.example.socialmediaapprestapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int countuser = 0;
	static {
		users.add(new User(++countuser, "user-1", LocalDate.now().minusYears(20)));
		users.add(new User(++countuser, "user-2", LocalDate.now().minusYears(22)));
		users.add(new User(++countuser, "user-3", LocalDate.now().minusYears(30)));
		users.add(new User(++countuser, "user-4", LocalDate.now().minusYears(24)));
		users.add(new User(++countuser, "user-5", LocalDate.now().minusYears(10)));
		users.add(new User(++countuser, "user-6", LocalDate.now().minusYears(23)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++countuser);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
	}
	
}
