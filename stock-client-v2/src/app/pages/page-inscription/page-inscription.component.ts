import { Component, OnInit } from '@angular/core';
import { EntrepriseService } from 'src/app/services/entreprise/entreprise.service';
import { EntrepriseDto } from '../../../gs-api/src/models/entreprise-dto';
import { AdresseDto } from '../../../gs-api/src/models/adresse-dto';
import { UserService } from 'src/app/services/user/user.service';
import { AuthenticationRequest } from '../../../gs-api/src/models/authentication-request';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-inscription',
  templateUrl: './page-inscription.component.html',
  styleUrls: ['./page-inscription.component.scss'],
})
export class PageInscriptionComponent implements OnInit {
  entrepriseDto: EntrepriseDto = {};
  adresse: AdresseDto = {};
  errorMessage: Array<string> = [];

  constructor(
    private entrepriseService: EntrepriseService,
    private userService: UserService,
    private route:Router
  ) { }

  ngOnInit(): void { }

  inscrire(): void {
    this.entrepriseDto.adresse = this.adresse;
    this.entrepriseService.sinscrire(this.entrepriseDto).subscribe(
      (data) => {
        this.connectEntreprise();
      },
      (error) => {
        console.log(error);
        this.errorMessage = error.error.errors;
      }
    );
  }


  connectEntreprise():void{
    const authenticationRequest: AuthenticationRequest = {
      login: this.entrepriseDto.email,
      password: 'admin'
    };
    this.userService.login(authenticationRequest)
      .subscribe((Response) => {
        this.userService.setAccessToken(Response);
        this.getUserByEmail(authenticationRequest.login);//permet le stockage de l'utilisateur dans le localStorage apres son incription
        localStorage.setItem('origin','inscription');
        this.route.navigate(['changermotdepasse']);
      });
  }

  getUserByEmail(email?:string): void {
    this.userService.getUserByEmail(email)
      .subscribe((user) => {
        this.userService.setConnectedUser(user);
      });
  }
}
