import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import {TaskService} from '../services/task.service';
import { ProjectVO } from './projectVO';
import { Router } from '@angular/router';


@Component({
  selector: 'app-addproject',
  templateUrl: './addproject.component.html',
  styleUrls: ['./addproject.component.css']
})
export class AddprojectComponent implements OnInit {
  project: ProjectVO = new ProjectVO();
  modalHeading : string = 'Select the manager';
  modalBody : string = '';
  constructor() { }

  ngOnInit() {
  }

}
