package com.LittleFlower.staffinformationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LittleFlower.staffinformationsystem.model.StudentDetailsEntity;
@Repository
public interface StudentDetailsEntitiyRepository extends CrudRepository<StudentDetailsEntity, Long> {
	
	@Query("SELECT  MAX(studentIdentifier) FROM StudentDetailsEntity s") 
	 int findMaxId();
	 @Query("SELECT s FROM StudentDetailsEntity s where s.firstName LIKE :search% OR s.lastName LIKE :search% OR s.grade LIKE :search% OR s.emailIdentifier LIKE :search% or s.studentIdentifier LIKE :search% ") 
	 List<StudentDetailsEntity> findBySearchParam(@Param("search") String search);
	
	
	
	
	

}
