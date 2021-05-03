import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Categorie} from "../_models/categorie";
import {Observable} from "rxjs";

const baseUrl = 'http://localhost:8081/api/categories';
@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient) {
  }

  public getAllCategories(): Observable<Categorie[]> {

    return this.http.get<Categorie[]>(baseUrl);
  }

  getAll() {
    return this.http.get(baseUrl);
  }

  getCategorieById(id):Observable<Categorie> {
    return this.http.get<Categorie>(`${baseUrl}/${id}`);
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

  findByTitle(nom):Observable<Categorie[]> {
    return this.http.get<Categorie[]>(`${baseUrl}?nom=${nom}`);
  }

  findByCode(code):Observable<Categorie> {
    return this.http.get<Categorie>(`${baseUrl}/code?code=${code}`);
  }

}
