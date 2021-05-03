import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./_services/token-storage.service";
import {TranslateService} from "@ngx-translate/core";
import {CategorieService} from "./_services/categorie.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Gestion des stocks';
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  showUserBoard=false;
  username: string;

  constructor(private tokenStorageService: TokenStorageService, private cat:CategorieService){

  }
  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    console.log("this.isLoggedIn: " + this.isLoggedIn);

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      //includes(): Methode qui determine si un tableau contient et retourne true sinon elle retourne false
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      this.showUserBoard = this.roles.includes('ROLE_User');

      this.username = user.username;
      console.log("this.username: " + this.username);
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

  public changeLanguage(code: string) {
    localStorage.setItem('locale', code);
    window.location.reload();
  }
}
