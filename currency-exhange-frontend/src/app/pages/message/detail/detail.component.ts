import { Component, OnInit ,Output, EventEmitter,Input} from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import {Currency, CurrencyExchange, Operation} from '../../../model/model.index'
import swal from 'sweetalert2'
@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html'
})
export class DetailComponent implements OnInit {

  currencyExchange:CurrencyExchange;

  operationCurrency : Operation;
  

  valueCodeCurrencyOrigin="From";
  valueCodeCurrencyDestiny="To";

  @Output() newOperation: EventEmitter<Operation> = new EventEmitter();

  
  @Input() currencyList:Currency[];

  currencyDestinyList:any[];

  constructor(private apiService:ApiService) { 

    this.operationCurrency = new Operation();
    this.operationCurrency .amount=0;
    this.currencyDestinyList=[];
    this.currencyExchange = new CurrencyExchange();
  }

  ngOnInit(): void {
  }

  logMessage(){
    console.log( this.currencyExchange);
  }
  
  changeComboCurrencyMain(){
    this.valueCodeCurrencyDestiny="To";   
    this.operationCurrency.exchangeValue =null;
    this.operationCurrency.currencyCodeDestiny=null;

  }

  changeCurrencyOrigin(codeCurrency){
    this.operationCurrency.currencyCodeOrigin=codeCurrency;
    this.valueCodeCurrencyOrigin =codeCurrency;
    this.changeComboCurrencyMain();
    let lisFilter =this.currencyList.filter((cu:any) =>cu.currencyCode==codeCurrency).map((y:any) => y.exchangeRates);
    console.log(lisFilter);
    this.currencyDestinyList = lisFilter[0];

    console.log(codeCurrency); 
    console.log(this.currencyDestinyList); 
  }

  changeCurrencyDestiny(codeCurrency){

    let listFilter = this.currencyDestinyList.filter((x:any)=> x.currencyCode==codeCurrency);
    console.log(listFilter);
    this.operationCurrency.exchangeValue = listFilter[0].exchangeValue;
    this.valueCodeCurrencyDestiny =codeCurrency;
    this.operationCurrency.currencyCodeDestiny=codeCurrency;
    console.log(codeCurrency); 
  }
 

  reset(){

    console.log("objeto enviar");
    console.log(this.operationCurrency);
    /*
    this.currencyExchange = new CurrencyExchange();        
  this.valueCodeCurrencyOrigin="From";
  this.valueCodeCurrencyDestiny="To";
  this.currencyDestinyList=null;
  */
  }
 

  doOperation(){

    let idCreacion:number=0;
 
//validation mandatories

if(this.operationCurrency.amount==null || this.operationCurrency.currencyCodeOrigin==null || this.operationCurrency.currencyCodeDestiny==null){
  swal.fire({
    icon: 'warning',
    title: 'Mandatory',
    text: 'Fields required: From, amount, to'
  });
return;
}


    this.apiService.create(this.operationCurrency).subscribe(
      (response)=>{      
        this.operationCurrency=response;
        swal.fire({
          icon: 'success',
          title: 'Operation Done',
          text: `Exchange amount ${this.operationCurrency.amountExchange}`
        });
       
        this.newOperation.emit(response);
      
      },
      error=>{
  
  
      },
      ()=>{

       // this.currencyExchange = new CurrencyExchange();     
      }
  
    );



  }

  

}
