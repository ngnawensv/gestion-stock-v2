import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {TokenStorageService} from '../_services/token-storage.service';

/**
 * Les "Guards" permettent de contrôler l'accès à une "route" ou le départ depuis une "route"
 */
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private tokenService: TokenStorageService, private router: Router) { }
  // ActivatedRouteSnapshot : contient des informations comme les paramètres envoyés pour la route demandée.
  // RouterStateSnapshot :contient des informations comme l’URL de la route demandée
  canActivate(
    route_param: ActivatedRouteSnapshot,
    route_url: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.tokenService.getToken()){
      return true;
    }
    return this.router.parseUrl("/home");
  }
  
}
