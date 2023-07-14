package com.LittleFlower.staffinformationsystem.service;

import java.util.List;

import org.hibernate.metamodel.mapping.internal.InFlightEntityMappingType;

import com.LittleFlower.staffinformationsystem.model.StaffDetailsEntity;

public interface StaffDetailsService {
	
  StaffDetailsEntity saveStaffDetails( StaffDetailsEntity staffDetail);
  
  List<StaffDetailsEntity> fetchStaffDetailsLlist();
  StaffDetailsEntity fetchStaffDetailsByID(long ID);
  List<StaffDetailsEntity>fetctchStaffDetailsBySearch(String search);
  
  void deleteStaffDetail(long id);
   long getMaxId();
  

}
