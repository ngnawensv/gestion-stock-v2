import { Injectable } from '@angular/core';
import { Api2articlesService } from 'src/gs-api/src/services';
import { UserService } from '../user/user.service';
import { ArticleDto } from '../../../gs-api/src/models/article-dto';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(
    private userService: UserService,
    private api2ArticleService:Api2articlesService
  ) { }

  saveArticle(articleDto: ArticleDto): Observable<ArticleDto>{
    articleDto.entrepriseId = this.userService.getConnectedUser().entreprise?.id;
    return this.api2ArticleService.save(articleDto);

  }

  findAllArticle(): Observable<ArticleDto[]>{
    return this.api2ArticleService.findAll();
  }

  findArticleById(idArticle?: number): Observable<ArticleDto>{
    if (idArticle) {
      return this.api2ArticleService.findById(idArticle);
    }
    return of();
  }

  deleteArticle(idArticle: number): Observable<any>{
    if (idArticle) {
      return this.api2ArticleService.delete(idArticle);
    }
    return of();
  }
}
