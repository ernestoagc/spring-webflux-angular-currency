import { Component, OnInit,Input ,OnDestroy} from '@angular/core';
import { Observable, Observer, Subscription } from 'rxjs';
import { ApiService } from 'src/app/services/api.service';
import {Operation} from '../../../model/model.index'
import  {EventSourceService} from '../../../services/event-source.service'
import { map, take } from 'rxjs/operators';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html'
})
export class ListComponent implements OnInit, OnDestroy {

  //@Input()newOperation:Operation[];

  operationsObserver: Observable<Operation[]>;
  
  private sseStream: Subscription;
  operations:Operation[] = [];
  constructor(private sseService: EventSourceService) { 
 
    this.sseStream = this.sseService
    .observeMessages(`http://localhost:7500/operations`)
    .pipe(
      map((message: any) => {
        message.date = new Date();
        return message;
      }),take(10)
    )
    .subscribe((message: Operation) => {
      this.operations.push(message);
    });

  }

  ngOnDestroy(): void {
    console.log("===>DESTRUIR");
    if (this.sseStream) {
      this.sseStream.unsubscribe();
    }
  }

  ngOnInit(): void {
    //this.loadOperations();
  }


 

}
