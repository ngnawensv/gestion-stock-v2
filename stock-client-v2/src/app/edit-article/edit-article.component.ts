import { Component, OnInit } from '@angular/core';
import {ArticleService} from "../_services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Article} from "../_models/article";
import {Categorie} from "../_models/categorie";
import {CategorieService} from "../_services/categorie.service";
import {error} from "selenium-webdriver";

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrls: ['./edit-article.component.css']
})
export class EditArticleComponent implements OnInit {

  article:Article=new Article();
  id_article:number;
  submited=false;

  listOfCategories:Categorie[];
  listCategorieOfArticle:Categorie[];
  categorieSelected:Categorie;
  categorieIdSelected:number;
  idCategorieOfArticleSelected:number;

  constructor(private articleService:ArticleService,
              private activetedRoute:ActivatedRoute,
              private categorieService:CategorieService,
              private router:Router) { }

  ngOnInit(): void {
    this.id_article=this.getIdArticleFromActivateRoute();
    this.getArticleById(this.id_article);
    this.getAllCategories();
  }

  getIdArticleFromActivateRoute(){
    return this.activetedRoute.snapshot.params['id'];
  }

  getArticleById(id){
    this.articleService.getArticleById(id).subscribe(
      data=>{
        this.article=data;
        //this.idCategorieOfArticleSelected=data.listOfCategories.pop().id;
      },
      error=> {
        console.log(error);
      }
    )
  }

  getAllCategories(){
    this.categorieService.getAllCategories().subscribe(
      data=>{
        this.listOfCategories=data;
        console.log(data);
      },
      error=>{
        console.log(error);
      }
    );
  }

  onCategorieSelected(id){
    this.categorieService.getCategorieById(id)
      .subscribe(
        data => {
          this.categorieSelected=data;
          console.log("categorieSelected");
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  /**
   * Methode pour mettre a jour un formualaire
   * @param id
   * @param currentArticle
   */
  updateArticle(currentArticle) {
    this.articleService.update(currentArticle.id, currentArticle)
      .subscribe(
        data => {
          console.log(data);
          this.submited=true;
          //this.currentArticle=null;
          //this.article_details=null;
          this.router.navigate(['articles'])
        },
        error => {
          console.log(error);
        });
  }




}
