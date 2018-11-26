import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddtaskComponent } from './addtask/addtask.component';
import { AddprojectComponent } from './addproject/addproject.component';
import { AdduserComponent } from './adduser/adduser.component';
import { ViewtaskComponent } from './viewtask/viewtask.component';
import { EdittaskComponent } from './edittask/edittask.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: 'addtask', component: AddtaskComponent },
  { path: 'viewtask', component: ViewtaskComponent },
  { path: 'edittask', component: EdittaskComponent },
  { path: 'addproject', component: AddprojectComponent },
  { path: 'adduser', component: AdduserComponent },
  { path: '',   redirectTo: '/addproject', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [
    RouterModule
  ]
   
})
export class AppRoutingModule { }
