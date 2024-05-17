import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistroUsuarioService {

  constructor(private http: HttpClient) { }

  registrarUsuario(usuario: any) {
    return this.http.post('http://localhost:8080/api/users/register', usuario)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {

      console.error('Ocorreu um erro:', error.error.message);
    } else {
      console.error(
        `Código de status ${error.status}, ` +
        `Erro: ${error.error}`);
    }
    return throwError('Algo deu errado; tente novamente mais tarde.');
  }
}
