package com.LittleFlower.staffinformationsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.LittleFlower.staffinformationsystem.model.StaffDetailsEntity;

@Service
public interface StaffDetailsService {
	
  StaffDetailsEntity saveStaffDetails( StaffDetailsEntity staffDetail);
  
  List<StaffDetailsEntity> fetchStaffDetailsLlist();
  StaffDetailsEntity fetchStaffDetailsByID(long ID);
  List<StaffDetailsEntity>fetctchStaffDetailsBySearch(String search);
  
  void deleteStaffDetail(long id);
   long getMaxId();
  

}
