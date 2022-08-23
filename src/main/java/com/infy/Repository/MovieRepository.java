package com.infy.Repository;

import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.entity.DirectorEntity;
import com.infy.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
	
	@Query(value="select movie_title from movie where movie_title like ?1"
			,nativeQuery = true)
	public String getdetailsByName(String s);
	
	@Query
	public List<MovieEntity> findByMovieTitleLike(String s);

	
	@Query(value ="select * from movie where movie_id"
			+ " in(select movie_id from movie_director where"
			+ " director_id =(select director_id from director where"
			+ " first_name=?1 and last_name=?2))" ,nativeQuery = true)
	public List<MovieEntity> getMovieDetailsByName(String fname,String lname);
	
	
	
	@Query(value="select movie_title from movie",nativeQuery=true)
	public List<String> findAllmovieTitle();

	@Modifying
	@Query(value="update movie set date = ?1 where movie_title like ?2",nativeQuery=true)
	public int setdateBymovieTitle(Date d,String s);
	
	@Modifying
	@Query(value="delete from movie where movie_title like ?1",nativeQuery = true)
	public int deleteBymovieTitle(String s);
	
	@Modifying
	@Query(value="delete from movie_director where movie_id in (select movie_id from movie where movie_title like ?1)",nativeQuery = true)
	public int deleteInMovieDirector(String s);
	
	
}
