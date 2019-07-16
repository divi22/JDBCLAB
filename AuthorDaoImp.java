package com.cap.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cap.crud.bean.Author;
import com.cap.crud.exception.AuthorException;
import com.cap.crud.exception.AuthorException;
import com.cap.crud.util.DatabaseConnection;
import com.cap.crud.exception.AuthorException;
import com.cap.crud.util.DatabaseConnection;


public class AuthorDaoImp implements AuthorDao {

	@Override
	public Integer addAuthor(Author author) throws AuthorException{
		Connection connection = null; 

		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;


		int queryResult=0;
		try
		{		
			connection = DatabaseConnection.getConnection();	
			preparedStatement=connection.prepareStatement("insert into author values (?,?,?,?,?)");

			preparedStatement.setInt(1,author.getAuthorId());			
			preparedStatement.setString(2,author.getFirstName());
			preparedStatement.setString(3,author.getMiddleName());
			preparedStatement.setString(4,author.getLastName());
			preparedStatement.setInt(5, author.getPhoneNo());

			queryResult=preparedStatement.executeUpdate();

			if(queryResult==0)
			{				
				throw new AuthorException("Inserting author details failed ");
			}		

		}
		catch(SQLException sqlException)
		{			
			throw new AuthorException("Tehnical problem occured");
		}

		finally
		{
			try 
			{
				if(connection!=null) {
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException sqlException) 
			{
				throw new AuthorException("Error in closing database connection");

			}
		}
		return queryResult;
		
	}
		
		
	

	@Override
	public List<Author> getAuthor() throws AuthorException {
		Connection con=null;

		PreparedStatement ps=null;
		ResultSet resultset = null;

		List<Author> authorList=new ArrayList<>();
		try
		{
			con=DatabaseConnection.getConnection();
			ps=con.prepareStatement("select * from author");
			resultset=ps.executeQuery();
			Author aut=new Author();
			while(resultset.next())
			{	
				
				aut.setAuthorId(resultset.getInt("authorId"));
				aut.setFirstName(resultset.getString("firstName"));
				aut.setMiddleName(resultset.getString("middleName"));
				aut.setLastName(resultset.getString("lastName"));
				aut.setPhoneNo(resultset.getInt("phoneNo"));
				authorList.add(aut);			

			}			

		} catch (SQLException sqlException) {

			throw new AuthorException("Tehnical problem occured. Refer log");
		}

		finally
		{
			try 
			{
				if(con!=null) {
					resultset.close();
					ps.close();
					con.close();
				}
			} 
			catch (SQLException e) 
			{			
				throw new AuthorException("Error in closing db connection");

			}
		}

		return authorList;
	}

		
    @Override
	public int updateAuthor( Integer phoneNo,Integer aid) throws AuthorException {
		// TODO Auto-generated method stub {
		Connection connection = null; 

		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;	

		int queryResult=0;
		try
		{		
			connection = DatabaseConnection.getConnection();	
			preparedStatement=connection.prepareStatement("update author set phoneNo=? where authorid=?");

			preparedStatement.setInt(1,phoneNo);
			preparedStatement.setInt(2,aid);

			queryResult=preparedStatement.executeUpdate();



		}
		catch(SQLException sqlException)
		{			
			throw new AuthorException("Tehnical problem occured");
		}

		finally
		{
			try 
			{
				if(connection!=null) {
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException sqlException) 
			{

				throw new AuthorException("Error in closing db connection");

			}
		}
		return queryResult;

	}

		
	
     @Override
	public int deleteAuthor(Integer aid) throws AuthorException{
		
		Connection connection = null; 

		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;	

		int queryResult=0;
		try
		{		
			connection = DatabaseConnection.getConnection();	
			preparedStatement=connection.prepareStatement("delete from author where authorid=?");

			preparedStatement.setInt(1,aid);

			queryResult=preparedStatement.executeUpdate();


		}
		catch(SQLException sqlException)
		{			
			throw new AuthorException("Tehnical problem occured");
		}

		finally
		{
			try 
			{
				if(connection!=null) {
					preparedStatement.close();
					connection.close();
				}
			}
			catch (SQLException sqlException) 
			{

				throw new AuthorException("Error in closing db connection");

			}
		}
		return queryResult;
	}
}









	



	
