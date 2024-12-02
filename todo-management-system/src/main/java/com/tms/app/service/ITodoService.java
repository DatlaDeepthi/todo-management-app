package com.tms.app.service;

import java.util.List;

import com.tms.app.dto.TodoDto;

public interface ITodoService {
	public TodoDto addTodo(TodoDto todoDto);

	public TodoDto getTodo(Long id);

	public List<TodoDto> getAllTodos();

	public TodoDto updateTodo(TodoDto todoDto, Long id);

	public void deleteTodo(Long id);

	public TodoDto completeTodo(Long id);

	public TodoDto inCompleteTodo(Long id);

}
