/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { UsersDto } from '../models/users-dto';
@Injectable({
  providedIn: 'root',
})
class Api2usersService extends __BaseService {
  static readonly findAllPath = '/api2/users';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de lister tous les utilisateurs de la BD
   * @return Liste des utilisateurs ou liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<UsersDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/users`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<UsersDto>>;
      })
    );
  }
  /**
   * Cette methode permet de lister tous les utilisateurs de la BD
   * @return Liste des utilisateurs ou liste vide
   */
  findAll(): __Observable<Array<UsersDto>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<UsersDto>)
    );
  }
}

module Api2usersService {
}

export { Api2usersService }
