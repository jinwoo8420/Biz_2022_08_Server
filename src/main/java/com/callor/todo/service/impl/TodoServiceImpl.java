package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;

	@Bean
	public void create_table() {
		todoDao.create_todo_table();
	}

	@Override
	public void create_todo_table() {

	}

	@Override
	public List<TodoVO> selectAll() {
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(String id) {
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		todoDao.insert(vo);
		return 0;
	}

	@Override
	public int update(TodoVO vo) {
		todoDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int complete(String id) {
		todoDao.complete(id);
		return 0;
	}

}
