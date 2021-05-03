import { Component, OnInit } from '@angular/core';
import {CategorieService} from "../_services/categorie.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.css']
})
export class AddCategorieComponent implements OnInit {

  public categorie = {code: '', nom: ''};
  submitted=false;
  constructor(private categorieServie: CategorieService,private router:Router) { }
  ngOnInit(): void {
  }
  saveCategorie() {
    const data = { code: this.categorie.code, nom: this.categorie.nom};
    this.categorieServie.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }
  newCategorie() {
    this.submitted = false;
    this.categorie = {code: '', nom: ''};
  }

  retourArriere(){
    this.router.navigateByUrl("/categories")
  }
}
