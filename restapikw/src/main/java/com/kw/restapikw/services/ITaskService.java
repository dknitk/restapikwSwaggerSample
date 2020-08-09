package com.kw.restapikw.services;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.kw.restapikw.model.Task;

public interface ITaskService {

	List<Task> getTodosByUser(String user);

	Optional<Task> getTodoById(long id);

	void updateTodo(Task todo);

	void addTodo(String name, String desc, Date targetDate, boolean isDone);

	void deleteTodo(long id);
	
	void saveTodo(Task todo);

}