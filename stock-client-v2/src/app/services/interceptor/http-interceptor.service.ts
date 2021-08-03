import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationResponse } from '../../../gs-api/src/models/authentication-response';

/**
 * Cette classe est utilisée pour intercepter toutes les requetes à destination du back-end et y ajouter le accessToken
 */
@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor{

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authenticationResponse: AuthenticationResponse = {};
    if (localStorage.getItem('accessToken')) {
      authenticationResponse = JSON.parse(localStorage.getItem('accessToken') as string);
      const authReq=req.clone({ headers:new HttpHeaders({Authorization:'Bearer '+authenticationResponse.accessToken})});
      return next.handle(authReq)
    }
    return next.handle(req)
  }
}
