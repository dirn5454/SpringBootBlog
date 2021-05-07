package com.woong.blog.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.woong.blog.model.Board;
import com.woong.blog.model.Users;
import com.woong.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Transactional
	public void write(Board board, Users users) {
		board.setCount(0);
		board.setUsers(users);
		boardRepository.save(board);
	}
	@Transactional
	public Page<Board> postList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}

	@Transactional
	public Board boardDetail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패");
				});
	}
	
	@Transactional
	public void deleteBoard(int id) {
		System.out.println("글 삭제하기: "+id);
		 boardRepository.deleteById(id);
	}	
	
	@Transactional
	public void updateBoard(int id, Board requestBoard) {
		System.out.println("글 수정하기: "+id);
		 Board board = boardRepository.findById(id)
				 .orElseThrow(()->{
						return new IllegalArgumentException("글 찾기 실패");
					});
		 board.setTitle(requestBoard.getTitle()); 
		 board.setContent(requestBoard.getContent());
	}
	
}