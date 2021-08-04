import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategorieService } from 'src/app/services/categorie/categorie.service';
import { UserService } from 'src/app/services/user/user.service';
import { CategorieDto } from 'src/gs-api/src/models';

@Component({
  selector: 'app-nouvelle-categorie',
  templateUrl: './nouvelle-categorie.component.html',
  styleUrls: ['./nouvelle-categorie.component.scss']
})
export class NouvelleCategorieComponent implements OnInit {

  categorieDto: CategorieDto = {};
  errorMsg: Array<string> = [];

  constructor(
    private categorieService: CategorieService,
    private userService: UserService,
    private route: Router
  ) { }

  ngOnInit(): void {
  }

  saveCategorie(): void{
    this.categorieDto.entrepriseId = this.userService.getConnectedUser()?.entreprise?.id;
    this.categorieService.saveCategorie(this.categorieDto).subscribe(
      data => {
        this.route.navigate(['categories']);
       },
      error => {
        this.errorMsg = error.error.errors;
      }
      );
  }

  cancelClick():void{
    this.route.navigate(['categories']);
  }

}
