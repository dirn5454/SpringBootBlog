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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.woong.blog.DTO.ResponseDto;
import com.woong.blog.config.auth.PrincipalDetail;
import com.woong.blog.model.Board;
import com.woong.blog.model.Reply;
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
	public ResponseDto<Integer> boardDeleteById(@PathVariable int id){
		boardService.deleteBoard(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		
	}

	@PutMapping("/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
		boardService.updateBoard(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 	
	}
	
	
	@PostMapping("/board/{boardId}/reply")
	public ResponseDto<Integer> saveReply(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal) { 		
		boardService.replyWrite(principal.getUsers(), boardId, reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	@DeleteMapping(value = "/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDeleteById(@PathVariable int replyId) { 		
		boardService.replyDelete(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	// ????????? ?????? ???
	@PutMapping(value = "/board/{boardId}/commandUpdateForm/{replyId}")
	public ResponseDto<Integer> replyWindowById(@PathVariable int replyId) { 		
		boardService.replyWindow(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	/*
	 sdsssssssssssssssssssss
	 ssss
	  
	@PostMapping("/board/{boardId}/commandUpdateForm")
	public ResponseDto<Integer> replySaveWindow(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal) { 		
		boardService.replyWriteWindow(principal.getUsers(), boardId, reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	*/
/*
	@PostMapping("/board/{boardId}/commandUpdateForm")
	public ResponseDto<Integer> windowReply(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal) { 		
		boardService.replyWindow(principal.getUsers(), boardId, reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	@PostMapping("/board/{boardId}/commandUpdateForm")
	public ResponseDto<Integer> windowReply(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal) { 		
		boardService.replyWindow(principal.getUsers(), boardId, reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	

	/*
	@PutMapping("/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyUpdate(@PathVariable int id, @RequestBody Board board){
		boardService.updateBoard(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 	
	}
	*/
	
	

	
}