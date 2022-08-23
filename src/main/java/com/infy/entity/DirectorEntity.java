package com.infy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Director")
public class DirectorEntity {
	
	@Id
	private Integer directorId;
	@Column(name="First_Name",length = 100)
	private String fName;
	@Column(name="Last_Name",length = 50)
	private String lName;
	@Column(name="Address",length = 150)
	private String address;
	@Column(name="Contact_Number")
	private Integer conNum;
	@Column(name="Email",length = 100)
	private String email;
	
	@ManyToMany(mappedBy = "directorsset")
	private Set<MovieEntity> moviesset = new HashSet<>();

	public DirectorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DirectorEntity(Integer directorId, String fName, 
			String lName, String address, Integer conNum, String email)
			 {
		super();
		this.directorId = directorId;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.conNum = conNum;
		this.email = email;
		
	}


	public Set<MovieEntity> getMoviesset() {
		return moviesset;
	}

	public void setMoviesset(Set<MovieEntity> moviesset) {
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

	




	@Override
	public String toString() {
		return "DirectorEntity [directorId=" + directorId + ", fName=" + fName + ", lName=" + lName + ", address="
				+ address + ", conNum=" + conNum + ", email=" + email +  "]";
	}




	
}
