import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Categorie} from "../_models/categorie";
import {Article} from "../_models/article";

const baseUrl = 'http://localhost:8081/api/articles';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) {
  }

  public getAllArticles(): Observable<Article[]> {

    return this.http.get<Article[]>(baseUrl);
  }

  getAll() {
    return this.http.get(baseUrl);
  }

  getArticleById(id):Observable<Article> {
    return this.http.get<Article>(`${baseUrl}/${id}`);
  }

  create(data) {
    return this.http.post(baseUrl, data);
  }

  update(id, data) {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id) {
    console.log(`${baseUrl}/${id}`)
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl);
  }

  findByKeyWord(nom):Observable<Article[]> {
    return this.http.get<Article[]>(`${baseUrl}?nom=${nom}`);
  }

}

