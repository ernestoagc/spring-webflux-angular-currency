import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Operation } from '../model/Operation.model';

interface StreamData {
  data: string;
}

@Injectable({
  providedIn: 'root'
})
export class EventSourceService {

  constructor() { }

  observeMessages(url: string): Observable<StreamData> {
    return new Observable<StreamData>(obs => {
      const es = new EventSource(url);
      
      es.addEventListener('message', (evt: StreamData) => {
      obs.next(evt.data != null ? JSON.parse(evt.data) : evt.data);
      },false);
      
      es.onmessage =(event)=>{
      }
      es.onopen=(event)=>{
      }
      return () => es.close();
    });
  }


  observeMessagesTwo(url: string): Observable<Operation> {
    return new Observable<Operation>(obs => {
      const es = new EventSource(url);
      
      es.onmessage =(event)=>{
           console.log("onmessage===>");
           console.log(event);
        return event;        
      }

      es.onopen=(event)=>{
       console.log("open===>");
       console.log(event);
      }

      
      return () => es.close();
    });
  }
}
