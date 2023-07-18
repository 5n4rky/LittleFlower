import { Component } from '@angular/core';
import { Input } from '@angular/core';
@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent {
  @Input() name?:String = 'Abhilash'
  @Input() class?:String = 'MCA'
  @Input() rollno?:String = '205121004'

  showresult:boolean = false;

  showResult():void{
    this.showresult = !this.showresult
  }
}
