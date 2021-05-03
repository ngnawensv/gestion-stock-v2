import { Component, OnInit } from '@angular/core';
import {CategorieService} from "../_services/categorie.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-update-categorie',
  templateUrl: './update-categorie.component.html',
  styleUrls: ['./update-categorie.component.css']
})
export class UpdateCategorieComponent implements OnInit {

  constructor(private categorieServie: CategorieService,private router:Router) { }

  ngOnInit(): void {
  }

  updateCategorie(id, currentCategorie) {
    currentCategorie.nom="toto";
    this.categorieServie.update(id, currentCategorie)
      .subscribe(
        response => {
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  retourArriere(){
    this.router.navigateByUrl("/categories")
  }
}
