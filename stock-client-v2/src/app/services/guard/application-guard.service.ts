import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../user/user.service';
/**
 * Cette service permet de filter les requettes. Elle evite l'access à l'application sans etre authentifier.
 * Par exemple l'accèss par modification direct d'un URL.Son utilisation est fait dans app-routing.module.ts
 * sur toutes les routes nécéssitant une authentification.
 */
@Injectable({
  providedIn: 'root'
})
export class ApplicationGuardService implements CanActivate{

  constructor(private userService:UserService) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {

    return this.userService.isUserLoggedAndAccessTokenValid();
  }
}
