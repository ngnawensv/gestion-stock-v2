import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

import { TokenStorageService } from '../_services/token-storage.service';

const TOKEN_HEADER_KEY = 'Authorization';

/**
 * HttpInterceptor has intercept() method to inspect and transform HTTP requests before they are sent to server.
 * AuthInterceptor implements HttpInterceptor. We’re gonna add Authorization header with ‘Bearer’ prefix to the token.
 */
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private token: TokenStorageService) { }

  /**
   * intercept() gets HTTPRequest object, change it and forward to HttpHandler object’s handle() method.
   * It transforms HTTPRequest object into an Observable<HttpEvents>.
   * next: HttpHandler object represents the next interceptor in the chain of interceptors.
   * The final ‘next’ in the chain is the Angular HttpClient.
   */
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let authReq = req;
      const token = this.token.getToken();
      if (token != null) {
        //clonage de la requete par l'ajout d'un nouvel entete
        authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
      }
      //Transmission de la requete clonée au lieu de la requete initiale
      return next.handle(authReq);
  }
}

export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];
