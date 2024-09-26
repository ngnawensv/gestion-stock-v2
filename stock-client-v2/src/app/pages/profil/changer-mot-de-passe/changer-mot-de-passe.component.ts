import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';
import { ChangerMotDePasseUserDto } from '../../../../gs-api/src/models/changer-mot-de-passe-user-dto';

@Component({
  selector: 'app-changer-mot-de-passe',
  templateUrl: './changer-mot-de-passe.component.html',
  styleUrls: ['./changer-mot-de-passe.component.scss']
})
export class ChangerMotDePasseComponent implements OnInit {

  changerMotDepasseDto: ChangerMotDePasseUserDto = {};
  ancienMotDePasse = '';
  errorMsg = '';

  constructor(
    private route: Router,
    private userService: UserService,
    ) { }

  ngOnInit(): void {
    if (localStorage.getItem('origin') && localStorage.getItem('origin') === 'inscription') {
      this.ancienMotDePasse = 'admin';
      localStorage.removeItem('origin');
    }
  }

  cancelClick():void{
    this.route.navigate(['profil'])
  }

  changerMotDePasseUser(): void{
    //On a besoin de l'id du mot de passe
    this.changerMotDepasseDto.id = this.userService.getConnectedUser().id;
    this.userService.changerMotDePasse(this.changerMotDepasseDto).subscribe(
      data => {
        this.route.navigate(['profil']);
      }, error => {
        this.errorMsg=error.error.message;
    });
  }

}
