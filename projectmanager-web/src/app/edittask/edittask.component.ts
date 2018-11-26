import { Component, OnInit } from '@angular/core';
import {TaskService} from '../services/task.service';
import { StaticTaskService } from '../services/static.service';
import { Task } from '../addtask/task';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edittask',
  templateUrl: './edittask.component.html',
  styleUrls: ['./edittask.component.css']
})
export class EdittaskComponent implements OnInit {
  task: Task = new Task();
  //editTask: any= {};
  constructor(private router: Router,private taskervice: TaskService, private staticTaskService: StaticTaskService) {
  }

  ngOnInit() {
    this.task = this.staticTaskService.editTask;
  }

  updateTask(task,taskId): void {
    console.log(task.task+task.taskId);
  this.taskervice.updateTask(task,task.taskId)
    .subscribe( data => {
 
     },
      error => {
        
     });
     this.router.navigate(['/viewtask']);
};

}
