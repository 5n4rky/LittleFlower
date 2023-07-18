package com.LittleFlower.staffinformationsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.LittleFlower.staffinformationsystem.model.StudentDetailsEntity;

@Service
public interface StudentDetailsSerive {
	
	StudentDetailsEntity saveStudentDetails(StudentDetailsEntity studentDetails);
	StudentDetailsEntity fetchStudentDetailsByID(long ID);
	List<StudentDetailsEntity>fetctchStudentDetailsBySearch(String search);
	List<StudentDetailsEntity>fetchStudentDetails();
	void deleteStudentDetail(long id);
	long getMaxId();

}
