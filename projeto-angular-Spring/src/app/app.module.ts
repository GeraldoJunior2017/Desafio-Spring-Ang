import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component'; 
import { RegistroUsuarioService } from '../app/services/registro-usuario.service'; 
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    RegistroUsuarioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
