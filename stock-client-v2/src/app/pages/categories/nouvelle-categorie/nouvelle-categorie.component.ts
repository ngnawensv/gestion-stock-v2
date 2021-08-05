import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    private route: Router,
    private activatedRoute:ActivatedRoute//permet de recuperer l'id de la categorie passée en paramètre lors de l'execution de la modification
  ) { }

  ngOnInit(): void {
    //Recuperation de l'id de la categorie comme paramettre
    const idCategorie = this.activatedRoute.snapshot.params.idCategorie;
      if (idCategorie) {
      this.categorieService.findByid(idCategorie).subscribe(
        data => {
          this.categorieDto = data;
        });
    }
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
