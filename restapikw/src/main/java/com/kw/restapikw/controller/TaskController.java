package com.kw.restapikw.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kw.restapikw.model.Task;
import com.kw.restapikw.services.ITaskService;

import io.swagger.annotations.Api;


@Controller
@Api(tags = "Task Contoller API")
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-tasks", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("tasks", taskService.getTodosByUser(name));
		// model.put("todos", service.retrieveTodos(name));
		return "list-tasks";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("task", new Task());
		return "task";
	}

	@RequestMapping(value = "/delete-task", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		taskService.deleteTodo(id);
		// service.deleteTodo(id);
		return "redirect:/list-tasks";
	}

	@RequestMapping(value = "/update-task", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
		Task todo = taskService.getTodoById(id).get();
		model.put("task", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-task", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Task todo, BindingResult result) {

		if (result.hasErrors()) {
			return "task";
		}

		todo.setUserName(getLoggedInUserName(model));
		taskService.updateTodo(todo);
		return "redirect:/list-tasks";
	}

	@RequestMapping(value = "/add-task", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Task todo, BindingResult result) {

		if (result.hasErrors()) {
			return "task";
		}

		todo.setUserName(getLoggedInUserName(model));
		taskService.saveTodo(todo);
		return "redirect:/list-tasks";
	}
}
