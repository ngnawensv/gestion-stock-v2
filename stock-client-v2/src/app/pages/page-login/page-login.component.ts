import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { AuthenticationRequest } from '../../../gs-api/src/models/authentication-request';
import { Router } from '@angular/router';
import { ApiService } from 'src/gs-api/src/services';

@Component({
  selector: 'app-page-login',
  templateUrl: './page-login.component.html',
  styleUrls: ['./page-login.component.scss'],
})
export class PageLoginComponent implements OnInit {
  authenticationRequest: AuthenticationRequest = {};
  errorMessage = '';

  constructor(
    private userService: UserService,
    private route: Router
  ) {}

  ngOnInit(): void {}

  login() {
    this.userService.login(this.authenticationRequest).subscribe(
      (data) => {
        this.userService.setAccessToken(data);
        this.getUserByEmail();
        this.route.navigate(['']);
      },
      (error) => {
        console.log(error);
        // debugger;
        // this.route.navigate(['inscrire']);
        this.errorMessage = 'Login et/ou mot de passe incorrect ';
      }
    );
  }

  getUserByEmail(): void {
    this.userService
      .getUserByEmail(this.authenticationRequest.login)
      .subscribe((user) => {
        this.userService.setConnectedUser(user);
      });
  }
}
