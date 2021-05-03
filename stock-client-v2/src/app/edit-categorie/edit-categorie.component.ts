import { Component, OnInit } from '@angular/core';
import {CategorieService} from "../_services/categorie.service";
import {Categorie} from "../_models/categorie";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-categorie',
  templateUrl: './edit-categorie.component.html',
  styleUrls: ['./edit-categorie.component.css']
})
export class EditCategorieComponent implements OnInit {
  categories:Categorie[];
  categorie:Categorie=new Categorie();
  id_categorie:number;
  submited=false;

  constructor(private categorieServie:CategorieService, private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    console.log(this.id_categorie);
    this.id_categorie= this.getIdCategorieFromActiveRoute();
    this.getCategorieById(this.id_categorie);
  }

  /**
   * This method return the id from the active route
   */
  getIdCategorieFromActiveRoute(){
    return this.activatedRoute.snapshot.params['id'];
  }

  /**
   * This method return an category from the id
   * @param id
   */
  getCategorieById(id){
   return this.categorieServie.getCategorieById(id).subscribe(
      data=>{
        this.categorie=data;
        console.log(data);
      },
      error=>{
        console.log(error);

      }
    )
  }

  /**
   * Methode pour mettre a jour un formualire
   * @param id
   * @param currentCategorie
   */
  updateCategorie(categorie) {
    this.categorieServie.update(categorie.id, categorie)
      .subscribe(
        response => {
          console.log(response);
          this.submited=true;
          this.router.navigate(['categories'])

        },
        error => {
          console.log(error);
        });
  }



  retourArriere(){
    //this.currentCategorie=null;
    //this.router.navigateByUrl("/categories")
  }
}
