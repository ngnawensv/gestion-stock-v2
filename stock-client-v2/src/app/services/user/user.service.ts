import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { UsersDto } from 'src/gs-api/src/models';
import { Api2authenticateService, Api2usersService, ApiService } from 'src/gs-api/src/services';
import { AuthenticationRequest } from '../../../gs-api/src/models/authentication-request';
import { AuthenticationResponse } from '../../../gs-api/src/models/authentication-response';
import { ChangerMotDePasseUserDto } from '../../../gs-api/src/models/changer-mot-de-passe-user-dto';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(
    private authenticationService: Api2authenticateService,
    private apiservice: ApiService,
    private api2service: Api2usersService,
    private route: Router
  ) {}

  login(authenticationRequest: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.authenticationService.authenticate(authenticationRequest);
  }

  getUserByEmail(email?: string):Observable<UsersDto> {
    if (email!=undefined) {
      return this.api2service.findByEmail(email);
    }
    return of(); //Retourne un objet vide
  }

  setAccessToken(authenticationResponse: AuthenticationResponse): void {
    localStorage.setItem('accessToken', JSON.stringify(authenticationResponse));
  }

  setConnectedUser(user:UsersDto) :void{
    localStorage.setItem('connectedUser',JSON.stringify(user));
  }

  getConnectedUser():UsersDto{
    if (localStorage.getItem('connectedUser')) {
      return JSON.parse(localStorage.getItem('connectedUser') as string);
    }
    return {};// returne un objet vide

  }

  changerMotDePasse(changerMotDePasseDto: ChangerMotDePasseUserDto): Observable<ChangerMotDePasseUserDto>{
    return this.api2service.changerMotDePasse(changerMotDePasseDto);
  }

  /**
   *
   * @returns Cette méthode permet de recuperer l'utilisateur connecté
   */
  //TODO
  isUserLoggedAndAccessTokenValid(): boolean {
    if (localStorage.getItem('accessToken')) {
      //TODO Il faut verifier que le accessToken est valide
      return true;
    }
    this.route.navigate(['login']);
    return false;
  }
}
