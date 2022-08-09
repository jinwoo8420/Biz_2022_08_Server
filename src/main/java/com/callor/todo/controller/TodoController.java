package com.callor.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<TodoVO> vo = todoService.selectAll();
		List<TodoVO> comp = todoService.complete();

		model.addAttribute("TODOS", vo);
		model.addAttribute("COMP", comp);

		return "todo/home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		TodoVO todoVO = TodoVO.builder().date(dayFormat.format(date)).time(timeFormat.format(date)).build();

		model.addAttribute("todoVO", todoVO);

		return "todo/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(TodoVO todoVO) {
		todoService.insert(todoVO);

		return "redirect:/todo";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("seq") int seq, Model model) {
		String st_seq = String.valueOf(seq);

		TodoVO todoVO = todoService.findById(st_seq);

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		todoVO = TodoVO.builder().seq(seq).date(dayFormat.format(date)).time(timeFormat.format(date))
				.todo(todoVO.getTodo()).build();

		model.addAttribute("todoVO", todoVO);

		return "todo/insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TodoVO todoVO) {
		todoService.update(todoVO);

		return "redirect:/todo";
	}

}