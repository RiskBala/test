import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { Task } from '../addtask/task';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TaskService {
  //private userUrl = 'http://localhost:8080/user-portal/user';
  private userUrl = 'http://localhost:7070';
  constructor(private http: HttpClient) { }

  public addTask(task) {
    return this.http.post<Task>(this.userUrl+'/addTask', task);
  }

  public viewTask() {
    return this.http.get<Task[]>(this.userUrl+'/viewTask');
  }
  public updateTask(task,taskId){
console.log(taskId+ task);
return this.http.post<string>(this.userUrl+'/editTask/'+taskId,task);
  }

  public endTask(taskId){
    console.log(taskId);
    return this.http.get<Task[]>(this.userUrl+'/deleteTask/'+taskId);
      }
  /* addTask(task, parentTask,startDate,endDate) {
    const uri = 'http://localhost:4000/task/add';
    const obj = {
      task: name,
      parentTask: parentTask,
      startDate:startDate,
      endDate:endDate

    };
    this.http.post(uri, obj)
        .subscribe(res => console.log('Done'));
  } */
}