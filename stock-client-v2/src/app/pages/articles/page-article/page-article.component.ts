import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article/article.service';
import { ArticleDto } from '../../../../gs-api/src/models/article-dto';
import {TranslationItemService} from "../../../services/translation-item.service";

@Component({
  selector: 'app-page-article',
  templateUrl: './page-article.component.html',
  styleUrls: ['./page-article.component.scss']
})
export class PageArticleComponent implements OnInit {

  listeArticle: Array<ArticleDto> = [];

  constructor(
    private route: Router,
    private articleService:ArticleService,
    private translate:TranslationItemService
  ) { }

  ngOnInit(): void {
    this.articleService.findAllArticle().subscribe(
      data => {
        this.listeArticle = data;
      },
      error => {

      }
    );
  }


  nouvelArticle():void{
    this.route.navigate(['nouvelarticle'])
  }

}
