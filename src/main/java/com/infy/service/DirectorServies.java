package com.infy.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Repository.DirectorRepository;
import com.infy.Repository.MovieRepository;
import com.infy.entity.DirectorEntity;
import com.infy.entity.MovieEntity;

@Service
@Transactional
public class DirectorServies {
	public static Scanner scan = new Scanner(System.in);
	@Autowired
	private DirectorRepository directorRepository;
	
	public void getDirector() {
		System.out.println("Enter name of movie to search:");
		String movieTitle =scan.next();
		List<DirectorEntity> list=directorRepository.getDirectorBymovieTitle(movieTitle);
		if(list.isEmpty())
			System.out.println("Invalid Movie Title");
		else
			list.stream().forEach(System.out::println);
	}
	
	public void updateDirector() {
		System.out.println("Enter director First name:");
		String fName= scan.next();
		System.out.println("Enter director Last name:");
		String lName= scan.next();
		try {
			directorRepository.getdetailsByName(fName,lName);
			System.out.println("Enter new Address");
			String add = scan.next();
			System.out.println("Enter new Contact Number");
			Integer cn = scan.nextInt();
			int i=directorRepository.setUpdateDirector(add,cn,fName,lName);
			System.out.println("Details updated successfully for "+fName+" "+lName);
		}catch (Exception e) {
			System.out.println("Enter valid details");
		}
	}
}
