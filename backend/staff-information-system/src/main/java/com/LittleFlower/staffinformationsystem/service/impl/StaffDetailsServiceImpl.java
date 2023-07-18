package com.LittleFlower.staffinformationsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LittleFlower.staffinformationsystem.model.StaffDetailsEntity;
import com.LittleFlower.staffinformationsystem.repository.StaffDetailsEntityRepository;
import com.LittleFlower.staffinformationsystem.service.StaffDetailsService;

@Service
public class StaffDetailsServiceImpl implements StaffDetailsService {
	
	@Autowired
	private StaffDetailsEntityRepository staffDetailsEntityRepository;
	
	@Override
	public StaffDetailsEntity saveStaffDetails( StaffDetailsEntity staffDetail) {
		return staffDetailsEntityRepository.save(staffDetail);
		
	}
	
	@Override
	public List<StaffDetailsEntity> fetchStaffDetails(){
		return (List<StaffDetailsEntity>)staffDetailsEntityRepository.findAll();
	}
	
	@Override
	public void deleteStaffDetail (long id) {
		staffDetailsEntityRepository.deleteById(id);
	}
	
	@Override
	public StaffDetailsEntity fetchStaffDetailsByID(long ID)
	{
		return staffDetailsEntityRepository.findById(ID).orElse(null);
	}
	@Override
	public long getMaxId()
	{
		return staffDetailsEntityRepository.findMaxId();
	}
	@Override
	public List<StaffDetailsEntity> fetctchStaffDetailsBySearch(String search){
		return staffDetailsEntityRepository.findBySearchParam(search);
	}
	

}
