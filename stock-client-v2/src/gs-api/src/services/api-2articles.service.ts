/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ArticleDto } from '../models/article-dto';
import { LigneCommandeFournisseurDto } from '../models/ligne-commande-fournisseur-dto';
@Injectable({
  providedIn: 'root',
})
class Api2articlesService extends __BaseService {
  static readonly updatePath = '/api2/articles';
  static readonly findHistoriqueCommandeFournisseurPath = '/api2/articles/historique/commandefournisseur/{idArticle}';
  static readonly findByCodePath = '/api2/articles/{code}';
  static readonly findByIdPath = '/api2/articles/{id}';
  static readonly deletePath = '/api2/articles/{id}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de modifier un article
   * @param body undefined
   * @return L'oject article modifier
   */
  updateResponse(body?: ArticleDto): __Observable<__StrictHttpResponse<ArticleDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api2/articles`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDto>;
      })
    );
  }
  /**
   * Cette methode permet de modifier un article
   * @param body undefined
   * @return L'oject article modifier
   */
  update(body?: ArticleDto): __Observable<ArticleDto> {
    return this.updateResponse(body).pipe(
      __map(_r => _r.body as ArticleDto)
    );
  }

  /**
   * @param idArticle undefined
   * @return successful operation
   */
  findHistoriqueCommandeFournisseurResponse(idArticle: number): __Observable<__StrictHttpResponse<Array<LigneCommandeFournisseurDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/articles/historique/commandefournisseur/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<LigneCommandeFournisseurDto>>;
      })
    );
  }
  /**
   * @param idArticle undefined
   * @return successful operation
   */
  findHistoriqueCommandeFournisseur(idArticle: number): __Observable<Array<LigneCommandeFournisseurDto>> {
    return this.findHistoriqueCommandeFournisseurResponse(idArticle).pipe(
      __map(_r => _r.body as Array<LigneCommandeFournisseurDto>)
    );
  }

  /**
   * Cette methode permet de rechercher un article par son code
   * @param code undefined
   * @return Article a été retrouvé dans la BD
   */
  findByCodeResponse(code: string): __Observable<__StrictHttpResponse<ArticleDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/articles/${code}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher un article par son code
   * @param code undefined
   * @return Article a été retrouvé dans la BD
   */
  findByCode(code: string): __Observable<ArticleDto> {
    return this.findByCodeResponse(code).pipe(
      __map(_r => _r.body as ArticleDto)
    );
  }

  /**
   * Cette methode permet de rechercher un article par son ID
   * @param id undefined
   * @return Article a été retrouvé dns la BD
   */
  findByIdResponse(id: number): __Observable<__StrictHttpResponse<ArticleDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/articles/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher un article par son ID
   * @param id undefined
   * @return Article a été retrouvé dns la BD
   */
  findById(id: number): __Observable<ArticleDto> {
    return this.findByIdResponse(id).pipe(
      __map(_r => _r.body as ArticleDto)
    );
  }

  /**
   * Cette methode permet de supprimer un article à partir de son ID
   * @param id undefined
   * @return Article supprimé avec succès
   */
  deleteResponse(id: number): __Observable<__StrictHttpResponse<ArticleDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api2/articles/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ArticleDto>;
      })
    );
  }
  /**
   * Cette methode permet de supprimer un article à partir de son ID
   * @param id undefined
   * @return Article supprimé avec succès
   */
  delete(id: number): __Observable<ArticleDto> {
    return this.deleteResponse(id).pipe(
      __map(_r => _r.body as ArticleDto)
    );
  }
}

module Api2articlesService {
}

export { Api2articlesService }
