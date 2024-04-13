package com.example.spring.TodoApplication.Todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;



@Controller
@SessionAttributes("name")
public class TodoController {
	
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;
	
	@RequestMapping("listtdos")
	public String listTodos(ModelMap model) {
		List<Todo> todos=todoService.findByusername("Aryan");
		model.addAttribute("todolist", todos);
		return "listtdos";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		String username=(String)model.get("name");
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addTodo( ModelMap model,@Valid Todo todo, BindingResult result){
		if(result.hasErrors()){
			return "add-todo";
		}
		
		String username=(String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusMonths(10), false);
		return "redirect:listtdos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteATodo(@RequestParam long id) {
		todoService.deleteTodo(id);
		
		return "redirect:listtdos";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
		Todo todo=todoService.findById(id);
		model.addAttribute("todo",todo);
		
		return "add-todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateATodo( ModelMap model,@Valid Todo todo, BindingResult result){
		if(result.hasErrors()){
			return "add-todo";
		}
		
		String username=(String)model.get("name");
		todo.setUsername(username);
		todoService.updateATodo(todo);
		return "redirect:listtdos";
	}
}
