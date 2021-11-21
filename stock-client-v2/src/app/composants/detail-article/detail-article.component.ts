import { Component, Input, OnInit } from '@angular/core';
import { ArticleDto } from '../../../gs-api/src/models/article-dto';
import { CategorieDto } from '../../../gs-api/src/models/categorie-dto';
import {Router} from "@angular/router";

import {Article} from "../../../gs-api/src/models/article";
import {TranslateService} from "@ngx-translate/core";

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
    private route:Router,
    private translate:TranslateService
  ) { }

  ngOnInit(): void {
  }

  modifierArticle() {
    this.route.navigate(['nouvelarticle',this.articleDto.id]);
  }

  getTranslateMessageValue(article: Article) {
    let message = '';
    this.translate
      .get('ARTICLE_DESIGNATION',{articleDesignation:article.designation})
      .subscribe((res: any) => {message = res;});
    return message;
  }
}
