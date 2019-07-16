package com.cap.crud.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cap.crud.bean.Author;
import com.cap.crud.dao.AuthorDao;
import com.cap.crud.dao.AuthorDaoImp;
import com.cap.crud.dao.AuthorDao;
import com.cap.crud.exception.AuthorException;

public class Starter {

	
		static void showMenu() {

			System.out.println("1-add author");
			System.out.println("2-get author details");
			System.out.println("3-update author");
			System.out.println("4-delete author");
			System.out.println("5-Exit");
			
		}

		public static void main(String[] args) throws SQLException, ClassNotFoundException, AuthorException {
			Scanner sc=new Scanner(System.in);
		    Author author=new Author();
		    AuthorDaoImp dao=new AuthorDaoImp();
			
			while(true) {
				showMenu();
				System.out.println("Enter choice");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Add new author");
					System.out.println("Enter author id:");
					Integer aid=sc.nextInt();
					System.out.println("Enter firstname:");
					String fname=sc.next();
					System.out.println("Enter middlename:");
					String mname=sc.next();
					System.out.println("Enter lastname:");
					String lname=sc.next();
					System.out.println("Enter phone number:");
					Integer phoneNo=sc.nextInt();
					
					author.setAuthorId(aid);
					author.setFirstName(fname);
					author.setMiddleName(mname);
					author.setLastName(lname);
					author.setPhoneNo(phoneNo);
					
					  
				   
				    Integer rows=dao.addAuthor(author);
				    System.out.println(rows+" row(s) inserted successfully");
				    
				    break;
				case 2:
					System.out.println("Display author details");
					List<Author> alist=new ArrayList<Author>();
					alist=dao.getAuthor();
					
					break;
				case 3:
					System.out.println("Update author phone number");
					System.out.println("Enter author id:");
					 aid=sc.nextInt();
					System.out.println("\n Enter author new phoneno" );
					phoneNo=sc.nextInt();
					rows=dao.updateAuthor(phoneNo,aid);
					  System.out.println(rows+"row(s) inserted successfully");
					break;
				case 4:
					System.out.println("Delete author details");
					System.out.println("Enter author id:");
					aid=sc.nextInt();
					rows=dao.deleteAuthor(aid);
					 System.out.println(rows+"row(s) inserted successfully\n");
					break;
				case 5:
					sc.close();
					System.exit(0);
					break;
					
					
					
				}
					
					
				}
			}
			

	}


