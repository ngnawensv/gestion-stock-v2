import { CategorieDto } from 'src/gs-api/src/models';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article/article.service';
import { ArticleDto } from '../../../../gs-api/src/models/article-dto';
import { CategorieService } from '../../../services/categorie/categorie.service';

@Component({
  selector: 'app-nouvel-article',
  templateUrl: './nouvel-article.component.html',
  styleUrls: ['./nouvel-article.component.scss']
})
export class NouvelArticleComponent implements OnInit {

  articleDto: ArticleDto = {};
  categorieDto: CategorieDto = {};
  listeCategorieDto: Array<CategorieDto> = [];
  errorMsg: Array<string> = [];

  constructor(
    private route: Router,
    private activatedRoute:ActivatedRoute,//permet de recuperer l'id de l'article passé en paramètre lors de l'execution de la modification
    private articleService: ArticleService,
    private categorieService:CategorieService
  ) { }

  ngOnInit(): void {
    this.findAllCategorie();
    this.getArticleById();
  }

  findAllCategorie(): void{
    this.categorieService.findAll().subscribe(
      data => {
        this.listeCategorieDto = data;
      }
    )
  }

  cancelClick():void{
    this.route.navigate(['articles']);
  }

  saveArticle() {
    this.articleDto.categorieDto = this.categorieDto;
    this.articleService.saveArticle(this.articleDto).subscribe(
      data => {
        this.route.navigate(['articles']);
      },
      error => {
        this.errorMsg = error.error.errors;
      }
    );
  }

  getArticleById(){
    const idArticle=this.activatedRoute.snapshot.params.idArticle;
    if(idArticle){
      this.articleService.findArticleById(idArticle).subscribe(
        data=>{
          this.articleDto=data;
          //we doing this test because categorieDto objet can be null
          this.categorieDto=this.articleDto.categorieDto?this.articleDto.categorieDto:{};
        }
      )
    }
  }

}
