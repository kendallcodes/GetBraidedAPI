package com.getbraided.repository;

import org.springframework.data.repository.CrudRepository;

import com.getbraided.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
