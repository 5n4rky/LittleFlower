package com.LittleFlower.staffinformationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LittleFlower.staffinformationsystem.model.StaffDetailsEntity;
@Repository
public interface StaffDetailsEntityRepository extends CrudRepository<StaffDetailsEntity, Long>{
	
	
	
	 @Query("SELECT  MAX(staffIdentifier) FROM StaffDetailsEntity s") 
	 int findMaxId();
	 @Query("SELECT s FROM StaffDetailsEntity s where s.firstName LIKE :search% OR s.lastName LIKE :search% OR s.emailIdentifier LIKE :search% or s.staffIdentifier LIKE :search% ") 
	 List<StaffDetailsEntity> findBySearchParam(@Param("search") String search);
	 
	 
	 
	 
	

}
