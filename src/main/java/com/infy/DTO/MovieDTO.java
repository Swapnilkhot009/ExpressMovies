package com.infy.DTO;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.entity.DirectorEntity;
import com.infy.service.MovieServices;

public class MovieDTO {
	
	@Autowired
    private	MovieServices movieServices;
	
	private Integer movieId;
	
	private String movieTitle;
	
    private Date relDate;
	
    private Time movieRunningTime;

    private Set<DirectorDTO> directorsset=new HashSet<>();
    
    
    
	public MovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieDTO(MovieServices movieServices, Integer movieId, String movieTitle, Date relDate,
			Time movieRunningTime) {
		super();
		this.movieServices = movieServices;
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.relDate = relDate;
		this.movieRunningTime = movieRunningTime;
		
	}

	public Set<DirectorDTO> getDirectorsset() {
		return directorsset;
	}

	public void setDirectorsset(Set<DirectorDTO> directorsset) {
		this.directorsset = directorsset;
	}

	public MovieServices getMovieServices() {
		return movieServices;
	}

	public void setMovieServices(MovieServices movieServices) {
		this.movieServices = movieServices;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public Time getMovieRunningTime() {
		return movieRunningTime;
	}

	public void setMovieRunningTime(Time movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}

    
}
