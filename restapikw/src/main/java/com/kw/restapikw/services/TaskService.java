package com.kw.restapikw.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kw.restapikw.model.Task;
import com.kw.restapikw.repository.TaskRepository;


@Service
public class TaskService implements ITaskService {

	@Autowired
	private TaskRepository todoRepository;

	@Override
	public List<Task> getTodosByUser(String user) {
		return todoRepository.findByUserName(user);
	}

	@Override
	public Optional<Task> getTodoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public void updateTodo(Task todo) {
		todoRepository.save(todo);
	}

	@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todoRepository.save(new Task(name, desc, targetDate, isDone));
	}

	@Override
	public void deleteTodo(long id) {
		Optional<Task> todo = todoRepository.findById(id);
		if (todo.isPresent()) {
			todoRepository.delete(todo.get());
		}
	}

	@Override
	public void saveTodo(Task todo) {
		todoRepository.save(todo);
	}
}