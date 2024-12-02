package com.tms.app.mapper;

import com.tms.app.dto.TodoDto;
import com.tms.app.entity.Todo;

public class TodoMapper {
	public static TodoDto mapToTodoDto(Todo todo) {
		return new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
	}

	public static Todo mapToTodo(TodoDto todoDto) {
		Todo savedTodo = new Todo();
		savedTodo.setId(todoDto.getId());
		savedTodo.setTitle(todoDto.getTitle());
		savedTodo.setDescription(todoDto.getDescription());
		savedTodo.setCompleted(todoDto.isCompleted());
		return savedTodo;
	}
}
