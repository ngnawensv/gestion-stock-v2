import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategorieDto } from '../../../../gs-api/src/models/categorie-dto';
import { CategorieService } from '../../../services/categorie/categorie.service';

@Component({
  selector: 'app-page-categories',
  templateUrl: './page-categories.component.html',
  styleUrls: ['./page-categories.component.scss']
})
export class PageCategoriesComponent implements OnInit {


  listeCategorie: Array<CategorieDto> = [];
  selectedCategorieIdToDelete?= -1;
  errorMsg = '';

  constructor(
    private route: Router,
    private categoriesService: CategorieService
  ) { }

  ngOnInit(): void {
    this.findAllCategorie();
  }


  findAllCategorie() {
    this.categoriesService.findAll().subscribe(
      data => {
        this.listeCategorie = data;
      },
      error => {

      }
    );
  }

  nouvelleCategorie():void{
    this.route.navigate(['nouvellecategorie']);
  }

  modifierCategorie(id?: number): void {
    this.route.navigate(['nouvellecategorie',id])
  }

  annulerSuppressionCat():void {
    this.selectedCategorieIdToDelete = -1;

  }


  confirmerEtSupprimerCat():void {
    if (this.selectedCategorieIdToDelete !== -1) {
      this.categoriesService.deleteCategorie(this.selectedCategorieIdToDelete).subscribe(
        data => {
          console.log(data);
          this.findAllCategorie();
        },
        error => {
          this.errorMsg=error.error.message;
        });
    }
  }

  selectCategoriePourSupprimer(id?: number): void{
    this.selectedCategorieIdToDelete = id;
  }
}
