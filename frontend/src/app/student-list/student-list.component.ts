
import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student-list/student.service';
import { ActivatedRoute, Router, NavigationEnd} from '@angular/router';
import { Staff, Student } from '../student';
import { HttpClient } from '@angular/common/http';
import axios from 'axios';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent {
  students: Student[] = []; 
  filteredStudents: any[] = [];
  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute,
    private router: Router,
    private http:HttpClient
  ) {
    this.filteredStudents = [
      {
        id: 1,
        first_name: 'John',
        last_name: 'dhdjd',
        role:'dkj'
      },
      {
        id: 2,
        first_name: 'Jane',
        last_name: 'dhdjd',
        role:'dkj'
      },
      
    ];
  }
  searchTerm: any;
  // get filteredStudents(): Student[] {
  //   // return this.students.filter((student) =>
  //   //   // this.filterStudents(student)
  //   // );
  // }
  // filterStudents(student: Student): boolean {
  //   return (
  //     (this.filterSubject1 === null || student.marksSubject1 === this.filterSubject1) &&
  //     (this.filterSubject2 === null || student.marksSubject2 === this.filterSubject2) &&
  //     (this.filterSubject3 === null || student.marksSubject3 === this.filterSubject3) &&
  //     (this.filterStudentId === null || student.id === this.filterStudentId)
  //   );
  // }
  serachTerm: any;
  documents1: any;
  documents2: any;
  searchQuery() {
    let scope="all";
    const apiUrl = 'http://localhost:8080/api/find/'+scope; 
    const searchUrl = `${apiUrl}?search=${this.searchTerm}`;
    const token = this.studentService.jwttoken;
  const headers = {
  Authorization: `Bearer ${token}`,
    };
axios.get(searchUrl, { headers })
  .then(response => {
    this.documents1 = response.data[0];
    this.documents2 = response.data[1];

    
  })
  .catch(error => {
    console.error(error);
  });
  }
  
  viewstudent(student: Student) {
    console.log(student.studentIdentifier);
    console.log("in viewStudebt",student.role);
        this.router.navigate(['view-students',student.studentIdentifier,student.role]);
  }
  viewStaff(staff:Staff) {
    console.log(staff.staffIdentifier);
        this.router.navigate(['view-students',staff.staffIdentifier,staff.role]);
      }

}
