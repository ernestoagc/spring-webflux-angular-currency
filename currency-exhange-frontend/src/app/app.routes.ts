import { Routes, RouterModule } from '@angular/router';
import { CurrencyComponent } from './pages/message/currency.component';


const appRoutes: Routes = [    
    
    { path: '**', redirectTo:'/',pathMatch:'full'}    ,
    { path: '', component: CurrencyComponent }
];

export const APP_ROUTES = RouterModule.forRoot(appRoutes,{useHash:false, scrollPositionRestoration:'enabled'})
