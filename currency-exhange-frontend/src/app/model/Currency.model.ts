import {ExchangeRate} from './ExchangeRate.model'

export class Currency{    
    id:string;
    currencyCode:string;
    currencyName:string;
    exchangeRates:ExchangeRate[];
}