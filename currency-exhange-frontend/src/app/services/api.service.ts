import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map, catchError} from 'rxjs/operators'
import { of, Observable, throwError } from 'rxjs';

import{Currency, Operation} from '../model/model.index'
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  //private urlEndPoint:string="https://messageangular.herokuapp.com/message/";
  private urlEndPoint:string="http://localhost:7500/";
  private httpHeaders:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
 

  constructor(private http:HttpClient) { }


  fetch():Observable<any>{
    return this.http.get(this.urlEndPoint+'findall/').pipe( 
      
     map (function(response:any) {    
         console.log("response: =>");
         console.log(response);            
       return   response;
       })
   );
   }

   create(operation:Operation):Observable<Operation>{
     console.log("===>object service");
     console.log(operation);
    return this.http.post<Operation>(this.urlEndPoint+'exchangerate/',operation,{headers:this.httpHeaders});
  }
 
}
