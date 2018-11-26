import { Component, OnInit,Pipe, PipeTransform } from '@angular/core';
import {TaskService} from '../services/task.service';
import { Task } from '../addtask/task';
import { Router } from '@angular/router';
import { StaticTaskService } from '../services/static.service';

@Component({
  selector: 'app-viewtask',
  templateUrl: './viewtask.component.html',
  styleUrls: ['./viewtask.component.css']
})
 
export class ViewtaskComponent implements OnInit{
 

  task: Task = new Task();
  taskList: any[] = [];
  constructor(private router: Router,private taskervice: TaskService, private staticTaskService: StaticTaskService) {
  }
   

  viewTask(): void {
   this.taskervice.viewTask()
       .subscribe( data => {
         this.taskList = data;
       },
       error => {
       // alert("ERROR");
      });


 };


editTask(task : any){
  this.staticTaskService.editTask = task;
  this.router.navigate(['/edittask']);
  
}

endTask(task : any){
  this.taskervice.endTask(task.taskId)
  .subscribe( data => {
    this.taskList = data;
  },error => {
     alert("ERROR");
   });
  
}

 /*addTask(task, parentTask,startDate, endDate) {
   this.taskervice.addTask(task,parentTask,startDate,endDate);
 }*/
 ngOnInit() {
  this.viewTask();
 }


}
