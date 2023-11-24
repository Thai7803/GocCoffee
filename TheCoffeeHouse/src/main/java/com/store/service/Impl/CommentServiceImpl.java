package com.store.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.DAO.CommentDAO;
import com.store.entity.Comment;
import com.store.entity.OrderDetail;
import com.store.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDAO commentDAO;

	@Override
	public Comment findByUsername(String username) {
		// TODO Auto-generated method stub
		return commentDAO.findByUsername(username);
	}

	@Override
	public Comment create(Comment comment) {
		// TODO Auto-generated method stub
		return commentDAO.save(comment);
	}

	@Override
	public Comment update(Comment comment) {
		// TODO Auto-generated method stub
		return commentDAO.save(comment);
	}



}
