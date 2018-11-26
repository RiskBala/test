import {Pipe, PipeTransform,Injectable } from '@angular/core';
import {DatePipe} from '@angular/common';
import {UserVO} from './userVO';

@Pipe({name:'UserPipe'})
@Injectable()
export class UserPipe implements PipeTransform{
    transform(usersList:UserVO[],field:string): UserVO[] {
       console.log(field + "field --->"+field)
    
       if (usersList && usersList.length){
        return usersList.filter(item =>{
            if (field === '' || field === undefined || field === null)
            {
                return true;
            }else if (field)
            {
                if(item.firstName.toLowerCase().indexOf(field.toLowerCase()) > -1){
                    return true;
                }
                if(item.lastName.toLowerCase().indexOf(field.toLowerCase()) > -1){
                    return true;
                }
                if(item.employeeId.toLowerCase().indexOf(field.toLowerCase()) > -1){
                    return true;
                }
            }else{
                return false;
            }
            return false;
       })
    }
    else{
        return usersList;
    }
    

     
}
}