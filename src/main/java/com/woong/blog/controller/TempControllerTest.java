package com.woong.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.woong.blog.service.BoardService;
import org.springframework.data.domain.Sort; 

@Controller
public class TempControllerTest {

	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(sort="id", direction= Sort.Direction.DESC)Pageable pageable) {
		model.addAttribute("boards", boardService.postList(pageable));
		return "index";
	}
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/writeForm") // 로직 수행 후 해당 주소로 매핑
	public String writeForm() {
		return "writeForm";
		
	}
	
	@GetMapping("/board/{id}") 
	public String findByld(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.boardDetail(id));
		
		return "detailForm";
	}
	
	
	@GetMapping("/board/{id}/updateForm") 
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "updateForm";
	}

	
	
	
}
