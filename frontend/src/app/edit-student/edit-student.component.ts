import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student-list/student.service';
import { Student } from '../student';
import { NgForm } from '@angular/forms';
import axios from 'axios';
@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {
  studentId: number | undefined;
  student: Student | undefined;
  editedStudent: Student | undefined;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentService
  ) { }
  id: any;
  role: any;
  documents: any;
  form!: NgForm;
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.role = params['role'] === "ADMIN" ? "staff" : params['role'];
    });
    const token = this.studentService.jwttoken;
    const headers = {
      Authorization: `Bearer ${token}`,
    };
    console.log("role", this.role);
    axios.get('http://localhost:8080/api/findById/' + this.id + "?scope=" + this.role + "s", { headers })
    .then(response => {
      this.documents= response.data;
    })
      .catch(error => {
      });
  }
  submitForm(): void {
    const formData = {
      staffIdentifier:this.documents.staffIdentifier,
      firstName: (<HTMLInputElement>document.getElementById('firstName'))?.value,
      lastName: (<HTMLInputElement>document.getElementById('lastName'))?.value,
      primaryContactNumber: this.documents.primaryContactNumber,
      secondaryContactNumber: this.documents.secondryContactNumber,
      addressText: this.documents.addressText,
      
      emailIdentifier: (<HTMLInputElement>document.getElementById('email'))?.value,
      role: this.documents.role,
      whtasppNumber: this.documents.whatsappNumber,
      classOwned : this.documents.classOwned

    };
   console.log(formData);
   const token = this.studentService.jwttoken;
   const headers = {
   Authorization: `Bearer ${token}`,
 };

// const requestBody = {
//   name: 'John Doe',
//   email: 'johndoe@example.com',
// };

axios.post('http://localhost:8080/api/update-staff-details', formData, { headers })
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });

    // Ma
    // if (this.documents.role === "STAFF" || this.documents.role === "ADMIN") {
    //   axios.post('http://192.168.101.86:8080/api/findById/' + this.id + "?scope=" + this.role + "s", { headers })
    //   .then(response => {
    //     this.documents= response.data;
    //   })
    //     .catch(error => {
    //     }); 
    // }
    // else {
    //   axios.post('http://192.168.101.86:8080/api/findById/' + this.id + "?scope=" + this.role + "s", { headers })
    //   .then(response => {
    //     this.documents= response.data;
    //   })
    //     .catch(error => {
    //     });
      //this.router.navigate(['/student-list']);
  }
}
