package com.LittleFlower.staffinformationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LittleFlower.staffinformationsystem.model.StaffDetailsEntity;
import com.LittleFlower.staffinformationsystem.service.StaffDetailsService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET , RequestMethod.POST , RequestMethod.DELETE})
public class MainController {

	
	
	
	@Autowired private StaffDetailsService staffDetailsService;
	private long generateId()
	{
		return staffDetailsService.getMaxId()+1;
		     	
	}
	//to do add find by id or name or number etc 
	
	
	
	@GetMapping("/api/find-all-staffs")
	public ResponseEntity<List<StaffDetailsEntity>> getAllStafs()
	{
		//
		 List<StaffDetailsEntity> staffs = staffDetailsService.fetchStaffDetailsLlist();
		 
	
		return ResponseEntity.ok(staffs);
	}
	
	@GetMapping("/api/find/{searchScope}/search")
	public ResponseEntity<List<StaffDetailsEntity>> findAll(@RequestParam String searchString , @PathVariable String searchScope) 
	{
		List<StaffDetailsEntity> searchResult = staffDetailsService.fetctchStaffDetailsBySearch(searchString);
		
	   return ResponseEntity.ok(searchResult);
		
		
		
	}
	
	
	
	@PostMapping("/api/add-staff-details")
	public ResponseEntity<StaffDetailsEntity> addStaffDetails(@RequestBody StaffDetailsEntity staffDetailsEntity)
	{  
	 long uId = generateId();
	 staffDetailsEntity.setStaffIdentifier(uId);
	  return ResponseEntity.ok(staffDetailsService.saveStaffDetails(staffDetailsEntity));
		
	}
	
	@PostMapping("/api/update-staff-details")
	public ResponseEntity<StaffDetailsEntity> updateStaffDetails(@RequestBody StaffDetailsEntity staffDetailsRequeset)
	{
		StaffDetailsEntity staffFromQuery=  staffDetailsService.fetchStaffDetailsByID(staffDetailsRequeset.getStaffIdentifier());
		if(staffFromQuery != null)
		{
			//take care of this in frontend , staffdetailRequest should contain all feilds
			staffDetailsRequeset.setStaffIdentifier(staffFromQuery.getStaffIdentifier());
			staffDetailsService.saveStaffDetails(staffDetailsRequeset);
			return ResponseEntity.ok(staffDetailsRequeset);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/api/delete-staff-details/{id}")
	public ResponseEntity<String> deleteStaffDetails(@PathVariable int id)
	{
		StaffDetailsEntity staffDetailsEntity = staffDetailsService.fetchStaffDetailsByID(id);
		if( staffDetailsEntity != null)
		{   
			staffDetailsService.deleteStaffDetail(id);
			return ResponseEntity.ok("deleted");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	
	
	
	
}
