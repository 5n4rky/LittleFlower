import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent {
  student: any = {}; // Adjust the type as per your student record structure

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const studentId = this.route.snapshot.paramMap.get('id');
    if (studentId) {
      // Hardcoded student record based on the ID
      this.student = { id: 1, first_name: 'John', age: 20 };
    }
  }

  saveStudent(): void {
    // Perform save/update logic here
    // For simplicity, we will just navigate back to the student list
    this.router.navigate(['/students']);
  }
}
