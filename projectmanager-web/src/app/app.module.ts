import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }          from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AddtaskComponent } from './addtask/addtask.component';
import { ViewtaskComponent } from './viewtask/viewtask.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { TaskService } from './services/task.service';
import { UserService } from './services/user.service';
import { StaticTaskService } from './services/static.service';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TaskPipe} from './viewtask/task.pipe';
import {UserPipe} from './adduser/user.pipe';
import { HeaderComponent } from './header/header.component';
import { EdittaskComponent } from './edittask/edittask.component';
import { AddprojectComponent } from './addproject/addproject.component';
import { AdduserComponent } from './adduser/adduser.component';

@NgModule({
  declarations: [
    AppComponent,
    AddtaskComponent,
    ViewtaskComponent,
    PageNotFoundComponent,
    TaskPipe,
    UserPipe,
    HeaderComponent,
    EdittaskComponent,
    AddprojectComponent,
    AdduserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  exports:[TaskPipe,UserPipe],
  providers: [TaskService, StaticTaskService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
