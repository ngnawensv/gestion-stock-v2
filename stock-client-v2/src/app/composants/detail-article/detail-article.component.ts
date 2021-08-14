import { Component, Input, OnInit } from '@angular/core';
import { ArticleDto } from '../../../gs-api/src/models/article-dto';
import { CategorieDto } from '../../../gs-api/src/models/categorie-dto';
import {Router} from "@angular/router";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {

  @Input()//Permet a un composant parent d'envoyer évenements/données a un composant fils
  articleDto: ArticleDto = {};
  categorieDto: CategorieDto = {};

  constructor(
    private route:Router
  ) { }

  ngOnInit(): void {
  }

  modifierArticle() {
    this.route.navigate(['nouvelarticle',this.articleDto.id]);
  }
}
