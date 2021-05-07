package com.woong.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.woong.blog.DTO.ResponseDto;
import com.woong.blog.config.auth.PrincipalDetail;
import com.woong.blog.model.Board;
import com.woong.blog.service.BoardService;


@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService; 
	
	@PostMapping("/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) { 		
		
		boardService.write(board, principal.getUsers());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	
	@DeleteMapping("/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardService.deleteBoard(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		
	}
	
	@RequestMapping(value = "/board/{id}", method=RequestMethod.PUT)
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
		boardService.updateBoard(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		
	}
	
	
}