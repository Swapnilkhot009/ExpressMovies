package com.infy.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.entity.DirectorEntity;
import com.infy.entity.MovieEntity;

@Repository
@Transactional
public interface DirectorRepository extends JpaRepository<DirectorEntity,Integer> {

	@Query(value="select * from director where director_id in "
			+ "(select director_id from movie_director where movie_id="
			+ "(select movie_id from movie where movie_title like ?1))",nativeQuery = true)
	public List<DirectorEntity> getDirectorBymovieTitle(String s);
	
	@Query(value="select director_id from director where first_name like ?1 "
			+ "and last_name like ?2",nativeQuery = true)
	public int getdetailsByName(String fName,String lName);
	
	@Modifying
	@Query(value="update director set address= ?1, contact_number= ?2 "
			+ "where first_name like ?3 and last_name like ?4",nativeQuery = true)
	public int setUpdateDirector(String address,Integer cn,String fName, String lName);
}
