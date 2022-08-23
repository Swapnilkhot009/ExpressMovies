package com.infy;


import java.security.PublicKey;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Month;
import java.util.Scanner;

import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.infy.DTO.DirectorDTO;
import com.infy.DTO.MovieDTO;
import com.infy.entity.DirectorEntity;
import com.infy.entity.MovieEntity;
import com.infy.service.DirectorServies;

import com.infy.service.MovieServices;

@SpringBootApplication
public class ExpressMoviesApplication implements CommandLineRunner{
	
	
	@Autowired
	private MovieServices mServices;
	
	@Autowired
	private DirectorServies dServies;
	
	public static Scanner scan  = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(ExpressMoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Run Each method by commenting others
		
	    System.out.println("==================================================");
	    System.out.println("Welcome to ExpressMovies");
	    System.out.println("1:Insert New Movie:\n"
	    		+ "2:Search movie by title:\n"
	    		+ "3:Search movie by director name:\n"
	    		+ "4:Search details about directors:\n"
	    		+ "5:Get list of all movies:\n"
	    		+ "6:Update movie relese data:\n"
	    		+ "7:Update direcotr details:\n"
	    		+ "8:Delete Movie:\n"
	    		+ "9:Exit ExpressMovies:");
	    System.out.println("==================================================\n"
	    		+ "Enter your Chooise.");
	    int chooise = scan.nextInt();
	    switch(chooise) {
	    case 1: mServices.insert(mServices.getNewMovieDTO());
	    break;
	    case 2: mServices.getMovieDetailsByTitle();
	    break;
	    case 3: mServices.getMovieDetailsBydirector();
	    break;
	    case 4: dServies.getDirector();
	    break;
	    case 5: mServices.getMovies();
	    break;
	    case 6: mServices.updateReleseDate();
	    break; 
	    case 7: mServices.updateReleseDate();
	    break;
	    case 8: mServices.deleteMovie();
	    break;
	    case 9: System.out.println("Thank you for using ExpressMovies");
	    	System.exit(0);
	    	return;
	    
	    default : System.out.println("Enter chooise provided in menu.");
	    
	    }
	    
	    
	}
}
