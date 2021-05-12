package com.woong.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woong.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
