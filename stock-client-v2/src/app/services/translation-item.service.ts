import { Injectable } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {Article} from "../../gs-api/src/models/article";

@Injectable({
  providedIn: 'root'
})
export class TranslationItemService {

  constructor(private translate: TranslateService) { }

  getTranslateMessageValue(article: Article) {
    let message = '';
    this.translate
      .get('ARTICLE_DESIGNATION',{articleDesignation:article.designation})
      .subscribe((res: any) => {message = res;});
    return message;
  }
}
