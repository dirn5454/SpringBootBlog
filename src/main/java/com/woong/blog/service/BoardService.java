package com.woong.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.woong.blog.model.Board;
import com.woong.blog.model.Reply;
import com.woong.blog.model.Users;
import com.woong.blog.repository.BoardRepository;
import com.woong.blog.repository.ReplyRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private ReplyRepository replyRepository;

	@Transactional
	public void write(Board board, Users users) {
		board.setCount(0);
		board.setUsers(users);
		boardRepository.save(board);
	}

	@Transactional
	public Page<Board> postList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Transactional
	public Board boardDetail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패");
		});
	}

	@Transactional
	public void deleteBoard(int id) {
		System.out.println("글 삭제하기: " + id);
		boardRepository.deleteById(id);
	}

	@Transactional
	public void updateBoard(int id, Board requestBoard) {
		System.out.println("글 수정하기: " + id);
		Board board = boardRepository.findById(id)

				.orElseThrow(() -> {
					return new IllegalArgumentException("글 찾기 실패");
				});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}

	@Transactional
	public void replyWrite(Users users, int boardId, Reply requestReply) {
		Board board = boardRepository.findById(boardId).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 작성 실패 : 게시글 id를 찾을 수 없습니다.");
		});

		requestReply.setUsers(users);
		requestReply.setBoard(board);

		replyRepository.save(requestReply);
		

	}

	@Transactional
	public void replyDelete(int replyId) {
		replyRepository.deleteById(replyId);
	}
	/*
	@Transactional
	public void replyWriteWindow(Users users, int boardId, Reply requestReply) {
		Board board = boardRepository.findById(boardId).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 작성 실패 : 게시글 id를 찾을 수 없습니다.");
		});

		requestReply.setUsers(users);
		requestReply.setBoard(board);

		replyRepository.save(requestReply);
	}
	*/
	
	@Transactional
	public Board replyDetail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 찾기 실패");
		});
	}
	
	
	//없어도 됨
	@Transactional
	public Board replyWindow(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 찾기 실패");
		});
	}
	
	/*
	@Transactional
	public Reply replyDetail(int id) {
		return replyRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 찾기 실패");
		});
	}
	sdssssss
	
	*/

}