import { Component, OnInit } from '@angular/core';
import {Categorie} from "../_models/categorie";
import {CategorieService} from "../_services/categorie.service";
import {Router} from "@angular/router";
import {Article} from "../_models/article";
import {ArticleService} from "../_services/article.service";

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  articles:Article[];
  article_details:Article=null;
  listCategorieOfArticle:Categorie[];
  currentArticle = null;
  currentIndex = -1;
  nom = '';
  submited=false;
  listOfCategories:Categorie[];
  categorieSelected:Categorie;


  constructor(private articleservice: ArticleService,
              private categorieService:CategorieService,
              private router:Router) {}

  ngOnInit(): void {
     //this.getAllCategories();
    /*this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true
    };*/
  }

  getAllArticles() {
    return this.articleservice.getAllArticles().subscribe(
      data => {
        this.articles = data;
        this.article_details=null;
        console.log(data);
        this.router.navigateByUrl("/articles")
      },
      error => {
        console.log("Erreur: " + error);
      });
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
  /**
   *
   */
  searchTitle() {
    this.articleservice.findByKeyWord(this.nom)
      .subscribe(
        data => {
          this.articles = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  deleteArticle(id){
    console.log(id)
    this.articleservice.delete(id).subscribe(
      response => {
        console.log(response);
        this.submited=true;
        this.getAllArticles();
        //this.router.navigate(['/categories']);
      },
      error => {
        console.log(error);
      });
  }

  /**
   * This method redirect to edit-article.component with article id
   * @param id
   */
  editArticle(id) {
    this.router.navigate(['articles/edit',id]);
  }

  detailsArticle(currentArticle:Article){
    this.article_details=currentArticle;
    //this.listCategorieOfArticle=this.article_details.listOfCategories;
    this.articles=[];
    this.articles.push(this.article_details);
    console.log(this.article_details);
  }

  retourArriere(){
    this.currentArticle=null;
    this.router.navigateByUrl("/articles")
  }



}
