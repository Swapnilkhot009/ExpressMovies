package com.infy.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.DirectorDTO;
import com.infy.DTO.MovieDTO;
import com.infy.Repository.MovieRepository;
import com.infy.entity.DirectorEntity;
import com.infy.entity.MovieEntity;

@Service
@Transactional
public class MovieServices {
	public static Scanner scan = new Scanner(System.in);
	@Autowired
	private MovieRepository movieRepository;
	
	public void insert(MovieDTO mDto) {
			if(mDto!=null) {
				MovieEntity mEntity = new MovieEntity();
				mEntity.setMovieId(mDto.getMovieId());
				mEntity.setMovieTitle(mDto.getMovieTitle());
				mEntity.setMovieRunningTime(mDto.getMovieRunningTime());
				mEntity.setRelDate(mDto.getRelDate());
				
				mDto.getDirectorsset().forEach(dto->{
					DirectorEntity dEntity = new DirectorEntity();
					dEntity.setDirectorId(dto.getDirectorId());
					dEntity.setfName(dto.getlName());
					dEntity.setlName(dto.getlName());
					dEntity.setEmail(dto.getEmail());
					dEntity.setAddress(dto.getAddress());
					dEntity.setConNum(dto.getConNum());
					mEntity.getDirectorsset().add(dEntity);
				});
				movieRepository.save(mEntity);
				System.out.println("New Movie "+mEntity.getMovieTitle()+" added successfully");
			}
	}
	public void getMovieDetailsByTitle() {
		System.out.println("Enter name of movie to search:");
		String movieTitle =scan.next();
		List<MovieEntity> list=movieRepository.findByMovieTitleLike(movieTitle);
		if(list.isEmpty())
			System.out.println("Invalid Movie Title");
		else
			list.stream().forEach(System.out::println);
	}
	public void getMovieDetailsBydirector() {
		System.out.println("Enter First Name of Director:");
		String fName =scan.next();
		System.out.println("Enter Last Name of Director:");
		String lName =scan.next();
		List<MovieEntity> list=movieRepository.
				getMovieDetailsByName(fName,lName);
		if(list.isEmpty())
			System.out.println("Invalid Director Name.");
		else
			list.stream().forEach(System.out::println);
	}
	
	
	public void getMovies() {
		List<String> list=movieRepository.findAllmovieTitle();
		list.stream().forEach(mov->System.out.println(mov.toString()));
	}
	public void updateReleseDate() {
		System.out.println("Enter Name of movie to update:");
		String name =scan.next();
		if(movieRepository.getdetailsByName(name)!=null) {
			System.out.println("Enter new Relesed Date yyyy-mm-dd:");
			String date = scan.next();
			int i=movieRepository.setdateBymovieTitle(Date.valueOf(date),name);
			System.out.println("Relese date of "+name+" updated to "+ date);
		}else {
			System.out.println("Enter valid movie as movie does not exists");
		}
		
	}
	
	public void deleteMovie() {
		System.out.println("Enter Name of movie delete:");
		String title = scan.next();
		try {
			int j=movieRepository.deleteInMovieDirector(title);
			int i=movieRepository.deleteBymovieTitle(title);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public MovieDTO getNewMovieDTO() {
		MovieDTO mDto =new MovieDTO();
		System.out.println("Enter integer MovieId:");
		Integer idInteger = scan.nextInt();
		mDto.setMovieId(idInteger);
		System.out.println("Enter MovieTitle:");
		String title = scan.next();
		mDto.setMovieTitle(title);
		if(movieRepository.getdetailsByName(title)!=null) {
			System.out.println("Try updating as "+title+" already Exists");
			return null;
		}else{
			
			System.out.println("Enter Relesed Date yyyy-mm-dd:");
			String dateString = scan.next();
			mDto.setRelDate(Date.valueOf(dateString));
			System.out.println("Enter hh:mm:ss");
			String time = scan.next();
			mDto.setMovieRunningTime(Time.valueOf(time));
			int check=1;
			while(check!=0) {
				System.out.println("Enter integer directorId:");
				Integer dirid = scan.nextInt();
				System.out.println("Enter director First name:");
				String fName= scan.next();
				System.out.println("Enter director Last name:");
				String lName= scan.next();
				System.out.println("Enter director Address:");
				String address= scan.next();
				System.out.println("Enter director Contact Numer:");
				Integer conNo= scan.nextInt();
				System.out.println("Enter director email:");
				String email= scan.next();
			    DirectorDTO ddto= new DirectorDTO(dirid,fName,lName,address,conNo,email);
			    mDto.getDirectorsset().add(ddto);
				System.out.println("Enter 1 to add more director and 0 to stop.");
				check = scan.nextInt();
			}
		}
		return mDto;
	}
}
