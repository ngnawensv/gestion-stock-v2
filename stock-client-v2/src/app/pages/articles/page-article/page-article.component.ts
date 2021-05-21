import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-article',
  templateUrl: './page-article.component.html',
  styleUrls: ['./page-article.component.scss']
})
export class PageArticleComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }
  nouvelArticle():void{
    this.route.navigate(['nouvelarticle'])
  }

}
