package com.tms.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.app.dto.TodoDto;
import com.tms.app.entity.Todo;
import com.tms.app.exception.ResourceNotFoundException;
import com.tms.app.mapper.TodoMapper;
import com.tms.app.repo.ITodoRepository;

@Service
public class TodoServiceImpl implements ITodoService {
	@Autowired
	private ITodoRepository todoRepo;

	@Override
	public TodoDto addTodo(TodoDto todoDto) {
		Todo todo = TodoMapper.mapToTodo(todoDto);
		Todo savedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(savedTodo);
	}

	@Override
	public TodoDto getTodo(Long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));
		return TodoMapper.mapToTodoDto(todo);
	}

	@Override
	public List<TodoDto> getAllTodos() {
		// TODO Auto-generated method stub
		List<Todo> todos = todoRepo.findAll();
		return todos.stream().map((todoList) -> TodoMapper.mapToTodoDto(todoList)).collect(Collectors.toList());

	}

	@Override
	public TodoDto updateTodo(TodoDto todoDto, Long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id).get();
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setCompleted(todoDto.isCompleted());
		Todo updatedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(updatedTodo);
	}

	@Override
	public void deleteTodo(Long id) {
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
		todoRepo.deleteById(id);

	}

	@Override
	public TodoDto completeTodo(Long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
		todo.setCompleted(Boolean.TRUE);
		Todo updatedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(updatedTodo);
	}

	@Override
	public TodoDto inCompleteTodo(Long id) {
		Todo todo = todoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
		todo.setCompleted(Boolean.FALSE);
		Todo updatedTodo = todoRepo.save(todo);
		return TodoMapper.mapToTodoDto(updatedTodo);
	}

}
