package com.LittleFlower.staffinformationsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LittleFlower.staffinformationsystem.model.StudentDetailsEntity;
import com.LittleFlower.staffinformationsystem.repository.StudentDetailsEntitiyRepository;
import com.LittleFlower.staffinformationsystem.service.StudentDetailsSerive;

@Service
public class StdentDetailsSercviceImpl implements StudentDetailsSerive{
	@Autowired
	private StudentDetailsEntitiyRepository studentDetailsEntitiyRepository;

	@Override
	public StudentDetailsEntity saveStudentDetails(StudentDetailsEntity studentDetails) {
		
		return studentDetailsEntitiyRepository.save(studentDetails);
	}

	@Override
	public StudentDetailsEntity fetchStudentDetailsByID(long ID) {
		
		return studentDetailsEntitiyRepository.findById(ID).orElse(null);
		
	}

	@Override
	public List<StudentDetailsEntity> fetctchStudentDetailsBySearch(String search) {
		// TODO Auto-generated method stub
		return  studentDetailsEntitiyRepository.findBySearchParam(search);
	}
	@Override
	public List<StudentDetailsEntity> fetchStudentDetails() {
		
		return  (List<StudentDetailsEntity>)studentDetailsEntitiyRepository.findAll();
	}

	@Override
	public void deleteStudentDetail(long id) {
		studentDetailsEntitiyRepository.deleteById(id);
		
	}

	@Override
	public long getMaxId() {
		
		return studentDetailsEntitiyRepository.findMaxId();
	}
	
	
	

}
