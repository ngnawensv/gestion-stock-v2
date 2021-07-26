/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { CategorieDto } from '../models/categorie-dto';
@Injectable({
  providedIn: 'root',
})
class Api2categoriesService extends __BaseService {
  static readonly findAllPath = '/api2/categories';
  static readonly savePath = '/api2/categories';
  static readonly findByIdPath = '/api2/categories/{id}';
  static readonly deletePath = '/api2/categories/{id}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer une liste des categories
   * @return La liste des categorie / une liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<CategorieDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/categories`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<CategorieDto>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer une liste des categories
   * @return La liste des categorie / une liste vide
   */
  findAll(): __Observable<Array<CategorieDto>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<CategorieDto>)
    );
  }

  /**
   * Cette methode permet d'enregistrer une categorie
   * @param body undefined
   * @return Catégorie créee avec succès
   */
  saveResponse(body?: CategorieDto): __Observable<__StrictHttpResponse<CategorieDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/categories`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CategorieDto>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer une categorie
   * @param body undefined
   * @return Catégorie créee avec succès
   */
  save(body?: CategorieDto): __Observable<CategorieDto> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as CategorieDto)
    );
  }

  /**
   * Cette methode permet de rechercher une categorie par son ID
   * @param id undefined
   * @return Categorie a été retrouvée dans la BD
   */
  findByIdResponse(id: number): __Observable<__StrictHttpResponse<CategorieDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/categories/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CategorieDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher une categorie par son ID
   * @param id undefined
   * @return Categorie a été retrouvée dans la BD
   */
  findById(id: number): __Observable<CategorieDto> {
    return this.findByIdResponse(id).pipe(
      __map(_r => _r.body as CategorieDto)
    );
  }

  /**
   * Cette methode permet de supprimer une categories à partir de son ID
   * @return Categorie supprimé avec succès
   */
  deleteResponse(id?:number): __Observable<__StrictHttpResponse<CategorieDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api2/categories/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CategorieDto>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer une categories à partir de son ID
   * @return Categorie supprimé avec succès
   */
  delete(id?:number): __Observable<CategorieDto> {
    return this.deleteResponse(id).pipe(
      __map(_r => _r.body as CategorieDto)
    );
  }
}

module Api2categoriesService {
}

export { Api2categoriesService }
