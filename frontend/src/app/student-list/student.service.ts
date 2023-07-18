import { Injectable } from '@angular/core';
import { Student } from '../student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  // private students: Student[] = [
  //   {
  //     id:
  //     first_name:
  //     last_name:,
  //     role:
  //   },
  //   {
  //     id: 2,
  //     first_name: 'Jane',
  //     last_name: 'dhdjd',
  //     role:'dkj'
  //   },
  //   // Add more students here as needed
  // ];

  // constructor() {}

  // // Method to get all students
  // getStudents(): Student[] {
  //   return this.students;
  // }

  // // Method to get a student by ID
  // getStudentById(id: number): Student | undefined {
  //   return this.students.find((student) => student.id === id);
  // }

  // // Method to add a new student
  // addStudent(student: Student): void {
  //   this.students.push(student);
  // }

  // // Method to update an existing student
  // updateStudent(student: Student): void {
  //   const index = this.students.findIndex((s) => s.id === student.id);
  //   if (index !== -1) {
  //     this.students[index] = student;
  //   }
  // }

  // // Method to delete a student by ID
  // deleteStudent(id: number): void {
  //   this.students = this.students.filter((student) => student.id !== id);
  // }
  jwttoken: any;
}
