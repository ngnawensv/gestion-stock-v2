import {Component, OnInit} from '@angular/core';
import {CategorieService} from "../_services/categorie.service";
import {Categorie} from "../_models/categorie";
import {Router} from "@angular/router";

@Component({
  selector: 'app-categorie',
  templateUrl: './categorie.component.html',
  styleUrls: ['./categorie.component.css']
})
export class CategorieComponent implements OnInit {

  categories:Categorie[];
  currentIndex = -1;
  nom = '';
  submited=false;

  constructor(private categorieServie: CategorieService, private router:Router) {}

  ngOnInit(): void {
 // this.getAllCategories();
    /*this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true
    };*/
  }

  getAllCategories() {
    return this.categorieServie.getAllCategories().subscribe(
      data => {
        this.categories = data;
        console.log(data);
        this.router.navigateByUrl("/categories")
      },
      error => {
        console.log("Erreur: " + error);
      });
  }
  /**
   *
   */
  searchTitle() {
    this.categorieServie.findByTitle(this.nom)
      .subscribe(
        data => {
            this.categories = data;
            console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  deleteCategorie(id){
    console.log(id)
    this.categorieServie.delete(id).subscribe(
      response => {
        console.log(response);
        this.submited=true;
        this.getAllCategories();
        //this.router.navigate(['/categories']);
      },
      error => {
        console.log(error);
      });
  }

  /**
   * This method redirect to edit-categorie.component with categorie id
   * @param id
   */
  editCategorie1(id) {
    this.router.navigate(['categories/edit',id]);
  }



}
