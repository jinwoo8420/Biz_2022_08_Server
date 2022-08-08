package com.callor.todo.persistance;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, String> {
	public void create_todo_table();
	
	public int complete(String id);
}
