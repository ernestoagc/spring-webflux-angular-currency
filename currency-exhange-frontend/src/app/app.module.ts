import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CurrencyComponent } from './pages/message/currency.component';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import {APP_ROUTES} from './app.routes';
import { NavbarComponent } from './shared/navbar/navbar.component'
import { ApiService } from './services/api.service';
import { ListComponent } from './pages/message/list/list.component';
import { DetailComponent } from './pages/message/detail/detail.component'
import {ValidationInterceptor} from './interceptor/validation.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CurrencyComponent,
    NavbarComponent,
    ListComponent,
    DetailComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    APP_ROUTES
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ValidationInterceptor,
      multi: true
    },
    ApiService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
