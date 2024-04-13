package com.example.spring.TodoApplication.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount=0;
	static{
		todos.add(new Todo(++todoCount,"Aryan","Learn Development",LocalDate.now().plusMonths(6),false));
		todos.add(new Todo(++todoCount,"Alex","Learn Devops",LocalDate.now().plusMonths(4),false));
	}
	
	public List<Todo> findByusername(String username){
		return todos;
	}
	
	public void addTodo(String username,String description,LocalDate targetdate,boolean done) {
		Todo todo= new Todo(++todoCount,username, description,targetdate,done);
		todos.add(todo);
	}
	
	public void deleteTodo(long id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		--todoCount;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateATodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
	
}
