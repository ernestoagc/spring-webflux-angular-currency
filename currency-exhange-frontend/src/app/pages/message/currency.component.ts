import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import {Currency} from '../../model/model.index'

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html'
})
export class CurrencyComponent implements OnInit {

  currencyList:Currency[];


  constructor(private apiService:ApiService) { }

  ngOnInit(): void {
    this.loadCurrencies();
  }


  saveSuccess(currency: Currency) {
    console.log("from the emit");
    console.log(currency);
  }

  loadCurrencies(){
    this.apiService.fetch().subscribe(

      response =>{
        this.currencyList=response;
      }

    )
  }
}
