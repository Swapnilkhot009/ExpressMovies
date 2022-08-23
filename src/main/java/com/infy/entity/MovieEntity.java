package com.infy.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "Movie")
public class MovieEntity {
	@Id
	@Column(name="Movie_Id")
	private Integer movieId;
	@Column(name="Movie_Title",length = 100)
	private String movieTitle;
	@Column(name="Date")
    private Date relDate;
	@Column(name="Movie_Running_Time")
    private Time movieRunningTime;
    
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="Movie_Director",joinColumns = @JoinColumn(name = "movieId")
	,inverseJoinColumns =@JoinColumn(name="directorId"))
	private Set<DirectorEntity> directorsset= new HashSet<>();
	
    
	
	public MovieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieEntity(Integer movieID, String movieTitle, 
			Date relDate,Time movRunTime) {
		super();
		this.movieId = movieID;
		this.movieTitle = movieTitle;
		this.relDate = relDate;
		this.movieRunningTime =movRunTime ;
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

	public Set<DirectorEntity> getDirectorsset() {
		return directorsset;
	}

	public void setDirectorsset(Set<DirectorEntity> directorsset) {
		this.directorsset = directorsset;
	}

	@Override
	public String toString() {
		return "MovieEntity [movieId=" + movieId + ", movieTitle=" + movieTitle + ", relDate=" + relDate
				+ ", movieRunningTime=" + movieRunningTime + ", directorsset=" + directorsset.toString() + "]";
	}
     
	

	
}
