import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { AuthGuard } from './auth.guard';
import { FrontPageComponent } from './front-page/front-page.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { StudentProfileComponent } from './student-profile/student-profile.component';
import { ViewStudentComponent } from './view-student/view-student.component';

const routes: Routes = [
  { path: '', redirectTo: '/login/teacher', pathMatch: 'full' },
  { path: 'front-page', component: FrontPageComponent },
  { path: 'login/teacher', component: LoginComponent },
  { path: 'login/student', component: StudentProfileComponent },
  { path: 'edit-student/:id/:role',component: EditStudentComponent },
  { path: 'students', component: StudentListComponent},
  { path: 'students', component: StudentDetailsComponent, canActivate: [AuthGuard] },
  { path: 'view-students/:id/:role',component: ViewStudentComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
