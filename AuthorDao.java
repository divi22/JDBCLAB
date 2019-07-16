package com.cap.crud.dao;

import java.util.List;

import com.cap.crud.bean.Author;
import com.cap.crud.exception.AuthorException;



public interface AuthorDao {
	public Integer addAuthor(Author author)throws AuthorException;
	public List<Author> getAuthor() throws AuthorException;
	
	public int deleteAuthor(Integer aid) throws AuthorException;
	public int updateAuthor(Integer aid, Integer phoneNo) throws AuthorException;

}
