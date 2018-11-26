import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { UserVO } from '../adduser/userVO';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {
  //private userUrl = 'http://localhost:8080/user-portal/user';
  private userUrl = 'http://localhost:7070';
  constructor(private http: HttpClient) { }

  public addUser(userVO) {
    return this.http.post<UserVO>(this.userUrl+'/users', userVO);
  }

  public getUsers() {
    return this.http.get<UserVO>(this.userUrl+'/users');
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