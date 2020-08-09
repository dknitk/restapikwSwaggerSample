package com.kw.restapikw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kw.restapikw.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> findByUserName(String user);
}
