package com.LittleFlower.staffinformationsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LittleFlower.staffinformationsystem.model.AuthenticationRequest;
import com.LittleFlower.staffinformationsystem.model.AuthenticationResponse;
import com.LittleFlower.staffinformationsystem.model.StaffDetailsEntity;
import com.LittleFlower.staffinformationsystem.model.StudentDetailsEntity;
import com.LittleFlower.staffinformationsystem.service.StaffDetailsService;
import com.LittleFlower.staffinformationsystem.service.StudentDetailsSerive;
import com.LittleFlower.staffinformationsystem.service.impl.UserDetailServiceImp;
import com.LittleFlower.staffinformationsystem.util.JwtUtil;

import net.bytebuddy.asm.Advice.Return;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET , RequestMethod.POST , RequestMethod.DELETE})
public class MainController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailServiceImp userDetailService;
	@Autowired
	private JwtUtil jwtUtil;
	
	public String getUsernameFromJwt(HttpServletRequest request)
	{
		  String authorizationHeader = request.getHeader("Authorization");
		  
		  String username = null; String jwt = null;
		  
		  
		   jwt = authorizationHeader.substring(7); 
		   username = jwtUtil.extractUsername(jwt); 
		   return username;
	}
	public String getRoleFromJwtUsername(String username)
	{
		//logic to check if its a student or a staff
		long uId = Long.parseLong(username);
		if(uId >= 1000)return "students";
		return "staffs";
	}
	
	
	
	@Autowired private StaffDetailsService staffDetailsService;
	@Autowired private StudentDetailsSerive studentDetailsSerive;
	private long staffGenerateId()
	{
		return staffDetailsService.getMaxId()+1;
		     	
	}
	private long studGenerateId()
	{
		return studentDetailsSerive.getMaxId()+1;
	}
	//to do add find by id or name or number etc 
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse>login(@RequestBody AuthenticationRequest authenticationRequest ) throws Exception{
		
		
		 try { 
			// System.out.println("username password"+authenticationRequest.getUsername()+authenticationRequest.getPassword());
			 authenticationManager.authenticate( new
		 UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
		  authenticationRequest.getPassword())); 
			
		 
		 
		 } 
		 catch (Exception e) {
			 //System.out.println("cannot aujutjhenticate");
			 e.printStackTrace();
		  throw new Exception("incorrect username or password ",e); 
		  }
		 
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	@GetMapping("/api/logout")
	public ResponseEntity<?>logout(HttpServletRequest request) throws Exception{
		 String authToken = request.getHeader("Authorization");
		    if (authToken != null && authToken.startsWith("Bearer ")) {
		        String jwtToken = authToken.substring(7);
		        
		        // Blacklist the token or perform any other necessary cleanup tasks
		        jwtUtil.addTokenToBlacklist(jwtToken);
		        
		        // Perform additional logout logic if needed
		        
		        return ResponseEntity.ok().build();
		    }
		    
		    return ResponseEntity.badRequest().build();
	}
	
	
	
	@GetMapping("/api/find-all")
	public ResponseEntity<List<?>> getAllStafs(@RequestParam String scope)
	{
		if(scope.equalsIgnoreCase("staffs"))
		{
			List<StaffDetailsEntity> staffs = staffDetailsService.fetchStaffDetails();
			return ResponseEntity.ok(staffs);
		}
		else if(scope.equalsIgnoreCase("students"))
		{
			List<StudentDetailsEntity> students = studentDetailsSerive.fetchStudentDetails();
			return ResponseEntity.ok(students);
		}
		
		return ResponseEntity.badRequest().build();
		
		 
	
		
	}
	@GetMapping("/api/findById/{id}")
	
	public ResponseEntity<?> findById(@RequestParam String scope,@PathVariable Long id)
	{
		if(scope.equalsIgnoreCase("staffs"))
		{
			StaffDetailsEntity staffs = staffDetailsService.fetchStaffDetailsByID(id);
			return ResponseEntity.ok(staffs);
		}
		else if(scope.equalsIgnoreCase("students"))
		{
			StudentDetailsEntity students = studentDetailsSerive.fetchStudentDetailsByID(id);
			return ResponseEntity.ok(students);
		}
		
		return ResponseEntity.badRequest().build();
		
		 
	
		
	}
	
	@GetMapping("/api/find/{searchScope}")
	@CrossOrigin(origins="*", methods= {RequestMethod.GET , RequestMethod.POST , RequestMethod.DELETE})
	public ResponseEntity<List<?>> findAllBySearchParam(@RequestParam String search , @PathVariable String searchScope) 
	{
		List<StaffDetailsEntity> searchResultStaffs = new ArrayList<>();
		List<StudentDetailsEntity>searchResultStudent = new ArrayList<>();
		List<Object>combinedList = new ArrayList<>();
		
		if(searchScope.equalsIgnoreCase("all"))
		{
			searchResultStaffs = staffDetailsService.fetctchStaffDetailsBySearch(search);
			searchResultStudent= studentDetailsSerive.fetctchStudentDetailsBySearch(search);
			
			combinedList.add(searchResultStaffs);
			combinedList.add(searchResultStudent);
			return ResponseEntity.ok(combinedList);
			
		
		}
		if(searchScope.equalsIgnoreCase("staffs"))
		{
			searchResultStaffs = staffDetailsService.fetctchStaffDetailsBySearch(search);
			combinedList.add(searchResultStaffs);
			combinedList.add(searchResultStudent);
			return ResponseEntity.ok(combinedList);
			
		}
		
		if(searchScope.equalsIgnoreCase("students"))
		{
         searchResultStudent= studentDetailsSerive.fetctchStudentDetailsBySearch(search);
			
			combinedList.add(searchResultStaffs);
			combinedList.add(searchResultStudent);
			return ResponseEntity.ok(combinedList);
		}
		return ResponseEntity.badRequest().build();
		
		
		
	   
		
		
		
	}
	
	
	
	@PostMapping("/api/add/staff")
	public ResponseEntity<StaffDetailsEntity> addStaffDetails(HttpServletRequest request,@RequestBody StaffDetailsEntity staffDetailsEntity)
	{  
		
	 long uId = staffGenerateId();
	 staffDetailsEntity.setStaffIdentifier(uId);
	  return ResponseEntity.ok(staffDetailsService.saveStaffDetails(staffDetailsEntity));
		
	}
	@PostMapping("/api/add/student")
	public ResponseEntity<StudentDetailsEntity> addStudentDetail(@RequestBody StudentDetailsEntity studentDetailsEntity)
	{  
		
		
	 long uId = studGenerateId();
	 studentDetailsEntity.setStudentIdentifier(uId);
	  return ResponseEntity.ok(studentDetailsSerive.saveStudentDetails(studentDetailsEntity));
		
	}
	
	@PostMapping("/api/update-staff-details")
	public ResponseEntity<StaffDetailsEntity> updateStaffDetails(HttpServletRequest request,@RequestBody StaffDetailsEntity staffDetailsRequeset)
	{
		String username=getUsernameFromJwt(request);
		
		String roleFromJwtUsername=getRoleFromJwtUsername(username);
		if(roleFromJwtUsername.equalsIgnoreCase("students"))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		
		StaffDetailsEntity staffFromJwt = staffDetailsService.fetchStaffDetailsByID(Long.parseLong(username));
			
		boolean canEdit = false;
		
		if(staffFromJwt.getStaffIdentifier() != staffDetailsRequeset.getStaffIdentifier() && staffFromJwt.getRole().equalsIgnoreCase("ADMIN"))
			canEdit=true;
		if(staffFromJwt.getStaffIdentifier() == staffDetailsRequeset.getStaffIdentifier())
			canEdit=true;
		if(!canEdit)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		
		
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
	@PostMapping("/api/update-student-details")
	public ResponseEntity<StudentDetailsEntity> updateStudentDetails(HttpServletRequest request,@RequestBody StudentDetailsEntity studentDetailsEntity)
	{
		String username=getUsernameFromJwt(request);
		boolean canEdit = false;
		
		String roleFromJwtUsername=getRoleFromJwtUsername(username);
		if(roleFromJwtUsername.equalsIgnoreCase("students"))
		{
			StudentDetailsEntity studentFromJwt = studentDetailsSerive.fetchStudentDetailsByID(Long.parseLong(username));
			if(studentFromJwt.getStudentIdentifier() == studentDetailsEntity.getStudentIdentifier())
				canEdit=true;
			else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
		}
		else {
			StaffDetailsEntity staffFromJwt = staffDetailsService.fetchStaffDetailsByID(Long.parseLong(username));
			if(staffFromJwt.getRole().equalsIgnoreCase("ADMIN"))
			{
				canEdit=true;
			}
			if(staffFromJwt.getClassOwned().contains(studentDetailsEntity.getGrade()))
			{
				canEdit=true;
			}
			
			}
		
		if(!canEdit)return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		
		StudentDetailsEntity studentFormQuery=  studentDetailsSerive.fetchStudentDetailsByID(studentDetailsEntity.getStudentIdentifier());
		if(studentFormQuery != null)
		{
			//take care of this in frontend , staffdetailRequest should contain all feilds
			studentDetailsEntity.setStudentIdentifier(studentDetailsEntity.getStudentIdentifier());
			studentDetailsSerive.saveStudentDetails(studentDetailsEntity);
			return ResponseEntity.ok(studentDetailsEntity);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<String> deleteStaffDetails(HttpServletRequest request,@PathVariable Long id , @RequestParam String scope)
	{
		String username=getUsernameFromJwt(request);
		String roleFromJwtUsername=getRoleFromJwtUsername(username);
		if(roleFromJwtUsername.equalsIgnoreCase("students")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		StaffDetailsEntity staffFromJwt = staffDetailsService.fetchStaffDetailsByID(Long.parseLong(username));
		if(!staffFromJwt.getRole().equalsIgnoreCase("ADMIN"))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			
		
		if(scope.equalsIgnoreCase("staffs"))
		{
			
		StaffDetailsEntity staffDetailsEntity = staffDetailsService.fetchStaffDetailsByID(id);
		if( staffDetailsEntity != null)
		{   
			staffDetailsService.deleteStaffDetail(id);
			return ResponseEntity.ok("deleted staff id="+id);
		}
		
		
		}
		else if(scope.equalsIgnoreCase("students"))
		{
			StudentDetailsEntity studentDetailsEntity = studentDetailsSerive.fetchStudentDetailsByID(id);
			if(studentDetailsEntity != null)
			{
				studentDetailsSerive.deleteStudentDetail(id);
				return ResponseEntity.ok("deleted student id=" + id );
			}
			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	
	
	
	
	
}
