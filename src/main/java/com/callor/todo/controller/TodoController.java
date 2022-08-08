package com.callor.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

		model.addAttribute("TODOS", vo);

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
		
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		TodoVO todoVO = TodoVO.builder().date(dayFormat.format(date)).time(timeFormat.format(date)).build();

		model.addAttribute("todoVO", todoVO);

		return "todo/insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TodoVO todoVO) {
		int ret = todoService.update(todoVO);

		String str = String.format("redirect:/todo/detail?seq=%s", todoVO.getSeq());

		return str;
	}

	@RequestMapping(value = "/{seq}/complete", method = RequestMethod.POST)
	public String complete(@RequestParam("seq") int seq) {
		String t_seq = String.valueOf(seq);

		todoService.complete(t_seq);

		return "redirect:/todo";
	}
}
