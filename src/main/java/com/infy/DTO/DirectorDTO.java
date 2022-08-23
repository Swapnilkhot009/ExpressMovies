package com.infy.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.infy.entity.MovieEntity;

public class DirectorDTO {
	private Integer directorId;
	
	private String fName;
	
	private String lName;
	
	private String address;
	
	private Integer conNum;
	
	private String email;
	
	private Set<MovieDTO> moviesset=new HashSet<>();
	
	

	public DirectorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DirectorDTO(Integer directorId, String fName, 
			String lName, String address, Integer conNum, String email) {
		super();
		this.directorId = directorId;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.conNum = conNum;
		this.email = email;
		
	}

	public Set<MovieDTO> getMoviesset() {
		return moviesset;
	}

	public void setMoviesset(Set<MovieDTO> moviesset) {
		this.moviesset = moviesset;
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getConNum() {
		return conNum;
	}

	public void setConNum(Integer conNum) {
		this.conNum = conNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
