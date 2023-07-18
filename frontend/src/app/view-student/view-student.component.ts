import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student-list/student.service';
import { ActivatedRoute, Router, NavigationEnd} from '@angular/router';
import { Student } from '../student';
import { HttpClient } from '@angular/common/http';
import   axios  from 'axios';
@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent  implements OnInit{

  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute,
    private router: Router,
    private http:HttpClient
  ) {
    
  }
  id: any;
  role: any;
  documents: any;
  canEdit: any;
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.role = params['role'] === "ADMIN" ? "staff" : params['role'];
    });
    const token = this.studentService.jwttoken;
    const headers = {
      Authorization: `Bearer ${token}`,
    };
    console.log("role",this.role);
axios.get('http://localhost:8080/api/findById/'+this.id+"?scope="+this.role+"s", { headers})
  .then(response => {
    console.log("ts response",response.data);
    this.documents = response.data;
  if(this.documents.role === "STAFF" || this.documents.role==="ADMIN")
    {axios.post('http://localhost:8080/api/update-staff-details',this.documents, { headers})
    .then(response => {
      this.canEdit = true;
    })
      .catch(error => {
        this.canEdit = false;
      
      });
  }
    else{
      axios.post('http://localhost:8080/api/update-student-details',this.documents, { headers})
    .then(response => {
      this.canEdit = true;
      
    })
      .catch(error => {
        this.canEdit = false;
      
      });
    }
    
  })
  .catch(error => {
    console.error(error);
  });  
  }
  editStudent() {
    console.log("edit s",this.documents)
    this.router.navigate(['edit-student',this.documents.studentidentifier,this.documents.role]);
  }
  editStaff() {
    console.log("edit s",this.documents)
    this.router.navigate(['edit-student',this.documents.staffIdentifier,this.documents.role]);
  }

}
