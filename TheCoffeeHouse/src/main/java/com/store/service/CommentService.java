package com.store.service;

import com.store.entity.Comment;
import com.store.entity.OrderDetail;

public interface CommentService {

	Comment findByUsername(String username);

	public Comment create(Comment comment);

	public Comment update(Comment comment);

}
