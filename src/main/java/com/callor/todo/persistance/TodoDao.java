package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, String> {
	public void create_todo_table();

	public TodoVO findByUsername(String id);

	public List<TodoVO> complete();
}