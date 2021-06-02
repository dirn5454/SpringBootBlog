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
	
	// 해당하는 url주소에 사용할 jsp파일을 리턴하여 뜨게한다.
	@GetMapping("/board/{id}/updateForm") 
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "updateForm";
	}

	// -> 여기에서 reply의 content나, id값을 넘겨줘야함
	@GetMapping("/board/{id}/commandUpdateForm/{replyId}") 
	public String replyWindow(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "commandUpdateForm";
	}
	// 수정된 부분
	/*
	@GetMapping("/board/{id}/commandUpdateForm") 
	public @ResponseBody String replyIdWindow(@PathVariable int id) {
		
		return "commandUpdateForm";
	}
	*/
	/*
	@GetMapping("/board/{id}/commandUpdateForm") 
	public String replyWindow(@PathVariable int id, Model model) {
		model.addAttribute("reply",boardService.Detail(id));
		return "commandUpdateForm";
	}
	*/
	
}
