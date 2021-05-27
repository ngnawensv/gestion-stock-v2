/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ArticleDto } from '../models/article-dto';
import { LigneCommandeClientDto } from '../models/ligne-commande-client-dto';
import { LigneVenteDto } from '../models/ligne-vente-dto';
import { CategorieDto } from '../models/categorie-dto';
import { ClientDto } from '../models/client-dto';
import { CommandeFournisseurDto } from '../models/commande-fournisseur-dto';
import { CommandeClientDto } from '../models/commande-client-dto';
import { EntrepriseDto } from '../models/entreprise-dto';
import { FournisseurDto } from '../models/fournisseur-dto';
import { MouvementStockDto } from '../models/mouvement-stock-dto';
import { RolesDto } from '../models/roles-dto';
import { SousCategorieDto } from '../models/sous-categorie-dto';
import { UsersDto } from '../models/users-dto';
import { VenteDto } from '../models/vente-dto';
@Injectable({
  providedIn: 'root',
})
class ApiService extends __BaseService {
  static readonly findAllPath = '/api2/articles';
  static readonly savePath = '/api2/articles';
  static readonly findHistoriqueCommandeClientPath = '/api2/articles/historique/commandeclient/{idArticle}';
  static readonly findAllArticleByIdCategoriePath = '/api2/articles/historique/filtre/categorie/{idCategorie}';
  static readonly findHistoriqueVentesPath = '/api2/articles/historique/vente/{idArticle}';
  static readonly findByCodePath = '/api2/categories/code/{code}';
  static readonly save_1Path = '/api2/clients';
  static readonly findByIdPath = '/api2/clients/{id}';
  static readonly findAll_1Path = '/api2/commandesFournisseurs/all';
  static readonly save_2Path = '/api2/commandesFournisseurs/create';
  static readonly deleteArticlePath = '/api2/commandesFournisseurs/delete/article/{idCommande}/{idLigneCommande}';
  static readonly updateArticlePath = '/api2/commandesFournisseurs/update/article/{idCommande}/{idLigneCommande}/{idArticle}';
  static readonly updateEtatCommandePath = '/api2/commandesFournisseurs/update/etat/{idCommande}/{etatCommande}';
  static readonly updateQuantiteCommandePath = '/api2/commandesFournisseurs/update/quantite/{idCommande}/{idLigneCommande}/{idQuantite}';
  static readonly findAll_2Path = '/api2/commandesclients/all';
  static readonly save_3Path = '/api2/commandesclients/create';
  static readonly deleteArticle_1Path = '/api2/commandesclients/delete/article/{idCommande}/{idLigneCommande}';
  static readonly updateClientPath = '/api2/commandesclients/upadate/client/{idCommande}/{idClient}';
  static readonly updateArticle_1Path = '/api2/commandesclients/update/article/{idCommande}/{idLigneCommande}/{idArticle}';
  static readonly updateQuantiteCommande_1Path = '/api2/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{idQuantite}';
  static readonly findById_1Path = '/api2/commandesclients/{id}';
  static readonly findAll_3Path = '/api2/entreprises';
  static readonly findEntrepriseByCodePath = '/api2/entreprises/{code}';
  static readonly findEntrepriseByEmailPath = '/api2/entreprises/{email}';
  static readonly findById_2Path = '/api2/entreprises/{id}';
  static readonly findEntrepriseByNomPath = '/api2/entreprises/{nom}';
  static readonly findAll_4Path = '/api2/forunisseurs';
  static readonly findById_3Path = '/api2/forunisseurs/{id}';
  static readonly deletePath = '/api2/forunisseurs/{id}';
  static readonly mouvementStockArticlePath = '/api2/mouvementstock/filter/article/{idArticle}';
  static readonly sortieStockPath = '/api2/mouvementstock/sortie';
  static readonly savePhotoPath = '/api2/photos/{id}/{title}/{context}';
  static readonly findAll_5Path = '/api2/roles';
  static readonly save_4Path = '/api2/roles';
  static readonly findById_4Path = '/api2/roles/{id}';
  static readonly findSousCategorieByCodePath = '/api2/sousCategories/{code}';
  static readonly save_5Path = '/api2/users';
  static readonly findByEmailPath = '/api2/users/find/{email}';
  static readonly findById_5Path = '/api2/users/{id}';
  static readonly delete_1Path = '/api2/users/{id}';
  static readonly findById_6Path = '/api2/ventes/{id}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Cette methode permet de rechercher et renvoyer  la liste des categorie de la base de données
   * @return Liste des aticles / Liste vide
   */
  findAllResponse(): __Observable<__StrictHttpResponse<Array<ArticleDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
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
        return _r as __StrictHttpResponse<Array<ArticleDto>>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher et renvoyer  la liste des categorie de la base de données
   * @return Liste des aticles / Liste vide
   */
  findAll(): __Observable<Array<ArticleDto>> {
    return this.findAllResponse().pipe(
      __map(_r => _r.body as Array<ArticleDto>)
    );
  }

  /**
   * Cette methode permet d'enregistrer un article
   * @return Article créee avec succès
   */
  saveResponse(): __Observable<__StrictHttpResponse<ArticleDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
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
   * Cette methode permet d'enregistrer un article
   * @return Article créee avec succès
   */
  save(): __Observable<ArticleDto> {
    return this.saveResponse().pipe(
      __map(_r => _r.body as ArticleDto)
    );
  }

  /**
   * @return successful operation
   */
  findHistoriqueCommandeClientResponse(idArticle:number): __Observable<__StrictHttpResponse<Array<LigneCommandeClientDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/articles/historique/commandeclient/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<LigneCommandeClientDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findHistoriqueCommandeClient(idArticle:number): __Observable<Array<LigneCommandeClientDto>> {
    return this.findHistoriqueCommandeClientResponse(idArticle).pipe(
      __map(_r => _r.body as Array<LigneCommandeClientDto>)
    );
  }

  /**
   * @return successful operation
   */
  findAllArticleByIdCategorieResponse(idCategorie:number): __Observable<__StrictHttpResponse<Array<ArticleDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/articles/historique/filtre/categorie/${idCategorie}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ArticleDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findAllArticleByIdCategorie(idCategorie:number): __Observable<Array<ArticleDto>> {
    return this.findAllArticleByIdCategorieResponse(idCategorie).pipe(
      __map(_r => _r.body as Array<ArticleDto>)
    );
  }

  /**
   * @return successful operation
   */
  findHistoriqueVentesResponse(idArticle:number): __Observable<__StrictHttpResponse<Array<LigneVenteDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/articles/historique/vente/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<LigneVenteDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findHistoriqueVentes(idArticle:number): __Observable<Array<LigneVenteDto>> {
    return this.findHistoriqueVentesResponse(idArticle).pipe(
      __map(_r => _r.body as Array<LigneVenteDto>)
    );
  }

  /**
   * Cette methode permet de rechercher une categorie par son code
   * @return Categorie a été retrouvé dans la BD
   */
  findByCodeResponse(code:string): __Observable<__StrictHttpResponse<CategorieDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/categories/code/${code}`,
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
   * Cette methode permet de rechercher une categorie par son code
   * @return Categorie a été retrouvé dans la BD
   */
  findByCode(code:string): __Observable<CategorieDto> {
    return this.findByCodeResponse(code).pipe(
      __map(_r => _r.body as CategorieDto)
    );
  }

  /**
   * @return successful operation
   */
  save_1Response(): __Observable<__StrictHttpResponse<ClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/clients`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  save_1(): __Observable<ClientDto> {
    return this.save_1Response().pipe(
      __map(_r => _r.body as ClientDto)
    );
  }

  /**
   * @return successful operation
   */
  findByIdResponse(id:number): __Observable<__StrictHttpResponse<ClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/clients/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findById(id:number): __Observable<ClientDto> {
    return this.findByIdResponse(id).pipe(
      __map(_r => _r.body as ClientDto)
    );
  }

  /**
   * @return successful operation
   */
  findAll_1Response(): __Observable<__StrictHttpResponse<Array<CommandeFournisseurDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/commandesFournisseurs/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<CommandeFournisseurDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findAll_1(): __Observable<Array<CommandeFournisseurDto>> {
    return this.findAll_1Response().pipe(
      __map(_r => _r.body as Array<CommandeFournisseurDto>)
    );
  }

  /**
   * @return successful operation
   */
  save_2Response(): __Observable<__StrictHttpResponse<CommandeFournisseurDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/commandesFournisseurs/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeFournisseurDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  save_2(): __Observable<CommandeFournisseurDto> {
    return this.save_2Response().pipe(
      __map(_r => _r.body as CommandeFournisseurDto)
    );
  }

  /**
   * @return successful operation
   */
  deleteArticleResponse(idCommande:number, idLigneCommande:number): __Observable<__StrictHttpResponse<CommandeFournisseurDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api2/commandesFournisseurs/delete/article/${idCommande}/${idLigneCommande}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeFournisseurDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  deleteArticle(idCommande:number, idLigneCommande:number): __Observable<CommandeFournisseurDto> {
    return this.deleteArticleResponse(idCommande, idLigneCommande).pipe(
      __map(_r => _r.body as CommandeFournisseurDto)
    );
  }

  /**
   * @return successful operation
   */
  updateArticleResponse(idCommande:number,idLigneCommande:number,idArticle:number): __Observable<__StrictHttpResponse<CommandeFournisseurDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'PATCH',
      this.rootUrl + `/api2/commandesFournisseurs/update/article/${idCommande}/${idLigneCommande}/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeFournisseurDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  updateArticle(idCommande:number,idLigneCommande:number,idArticle:number): __Observable<CommandeFournisseurDto> {
    return this.updateArticleResponse(idCommande,idLigneCommande,idArticle).pipe(
      __map(_r => _r.body as CommandeFournisseurDto)
    );
  }

  /**
   * @return successful operation
   */
  updateEtatCommandeResponse(idCommande:number,etatCommande:string): __Observable<__StrictHttpResponse<CommandeFournisseurDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'PATCH',
      this.rootUrl + `/api2/commandesFournisseurs/update/etat/${idCommande}/${etatCommande}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeFournisseurDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  updateEtatCommande(idCommande:number,etatCommande:string): __Observable<CommandeFournisseurDto> {
    return this.updateEtatCommandeResponse(idCommande,etatCommande).pipe(
      __map(_r => _r.body as CommandeFournisseurDto)
    );
  }

  /**
   * @return successful operation
   */
  updateQuantiteCommandeResponse(idCommande:number,idLigneCommande:number,idQuantite:number): __Observable<__StrictHttpResponse<CommandeFournisseurDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'PATCH',
      this.rootUrl + `/api2/commandesFournisseurs/update/quantite/${idCommande}/${idLigneCommande}/${idQuantite}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeFournisseurDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  updateQuantiteCommande(idCommande:number,idLigneCommande:number,idQuantite:number): __Observable<CommandeFournisseurDto> {
    return this.updateQuantiteCommandeResponse(idCommande,idLigneCommande,idQuantite).pipe(
      __map(_r => _r.body as CommandeFournisseurDto)
    );
  }

  /**
   * @return successful operation
   */
  findAll_2Response(): __Observable<__StrictHttpResponse<Array<CommandeClientDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/commandesclients/all`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<CommandeClientDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findAll_2(): __Observable<Array<CommandeClientDto>> {
    return this.findAll_2Response().pipe(
      __map(_r => _r.body as Array<CommandeClientDto>)
    );
  }

  /**
   * @return successful operation
   */
  save_3Response(): __Observable<__StrictHttpResponse<CommandeClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/commandesclients/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  save_3(): __Observable<CommandeClientDto> {
    return this.save_3Response().pipe(
      __map(_r => _r.body as CommandeClientDto)
    );
  }

  /**
   * @return successful operation
   */
  deleteArticle_1Response(idCommande:number,idLigneCommande:number): __Observable<__StrictHttpResponse<CommandeClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api2/commandesclients/delete/article/${idCommande}/${idLigneCommande}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  deleteArticle_1(idCommande:number,idLigneCommande:number): __Observable<CommandeClientDto> {
    return this.deleteArticle_1Response(idCommande,idLigneCommande).pipe(
      __map(_r => _r.body as CommandeClientDto)
    );
  }

  /**
   * @return successful operation
   */
  updateClientResponse(idCommande:number,idClient:number): __Observable<__StrictHttpResponse<CommandeClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'PATCH',
      this.rootUrl + `/api2/commandesclients/upadate/client/${idCommande}/${idClient}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  updateClient(idCommande:number,idClient:number): __Observable<CommandeClientDto> {
    return this.updateClientResponse(idCommande,idClient).pipe(
      __map(_r => _r.body as CommandeClientDto)
    );
  }

  /**
   * @return successful operation
   */
  updateArticle_1Response(idCommande:number,idLigneCommande:number,idArticle:number): __Observable<__StrictHttpResponse<CommandeClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'PATCH',
      this.rootUrl + `/api2/commandesclients/update/article/${idCommande}/${idLigneCommande}/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  updateArticle_1(idCommande:number,idLigneCommande:number,idArticle:number): __Observable<CommandeClientDto> {
    return this.updateArticle_1Response(idCommande,idLigneCommande,idArticle).pipe(
      __map(_r => _r.body as CommandeClientDto)
    );
  }

  /**
   * @return successful operation
   */
  updateQuantiteCommande_1Response(idCommande:number,idLigneCommande:number,idQuantite:number): __Observable<__StrictHttpResponse<CommandeClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'PATCH',
      this.rootUrl + `/api2/commandesclients/update/quantite/${idCommande}/${idLigneCommande}/${idQuantite}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  updateQuantiteCommande_1(idCommande:number,idLigneCommande:number,idQuantite:number): __Observable<CommandeClientDto> {
    return this.updateQuantiteCommande_1Response(idCommande,idLigneCommande,idQuantite).pipe(
      __map(_r => _r.body as CommandeClientDto)
    );
  }

  /**
   * @return successful operation
   */
  findById_1Response(id:number): __Observable<__StrictHttpResponse<CommandeClientDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/commandesclients/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommandeClientDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findById_1(id:number): __Observable<CommandeClientDto> {
    return this.findById_1Response(id).pipe(
      __map(_r => _r.body as CommandeClientDto)
    );
  }

  /**
   * Cette methode permet de retourner la liste de toutes les entreprise
   * @return Entreprise retrouvée dans la base de données
   */
  findAll_3Response(): __Observable<__StrictHttpResponse<Array<EntrepriseDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/entreprises`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<EntrepriseDto>>;
      })
    );
  }
  /**
   * Cette methode permet de retourner la liste de toutes les entreprise
   * @return Entreprise retrouvée dans la base de données
   */
  findAll_3(): __Observable<Array<EntrepriseDto>> {
    return this.findAll_3Response().pipe(
      __map(_r => _r.body as Array<EntrepriseDto>)
    );
  }

  /**
   * Cette methode permet de rechercher une entreprise par son code
   * @return Entreprise retrouvée dans la base de données
   */
  findEntrepriseByCodeResponse(code:string): __Observable<__StrictHttpResponse<EntrepriseDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/entreprises/${code}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<EntrepriseDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher une entreprise par son code
   * @return Entreprise retrouvée dans la base de données
   */
  findEntrepriseByCode(code:string): __Observable<EntrepriseDto> {
    return this.findEntrepriseByCodeResponse(code).pipe(
      __map(_r => _r.body as EntrepriseDto)
    );
  }

  /**
   * Cette methode permet de rechercher une entreprise par son email
   * @return Entreprise retrouvée dans la base de données
   */
  findEntrepriseByEmailResponse(email:string): __Observable<__StrictHttpResponse<EntrepriseDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/entreprises/${email}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<EntrepriseDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher une entreprise par son email
   * @return Entreprise retrouvée dans la base de données
   */
  findEntrepriseByEmail(email:string): __Observable<EntrepriseDto> {
    return this.findEntrepriseByEmailResponse(email).pipe(
      __map(_r => _r.body as EntrepriseDto)
    );
  }

  /**
   * Cette methode permet de rechercher une entreprise par son ID
   * @return Entreprise retrouvée dans la base de données
   */
  findById_2Response(id:number): __Observable<__StrictHttpResponse<EntrepriseDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/entreprises/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<EntrepriseDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher une entreprise par son ID
   * @return Entreprise retrouvée dans la base de données
   */
  findById_2(id:number): __Observable<EntrepriseDto> {
    return this.findById_2Response(id).pipe(
      __map(_r => _r.body as EntrepriseDto)
    );
  }

  /**
   * Cette methode permet de rechercher une entreprise par son nom
   * @return Entreprise retrouvée dans la base de données
   */
  findEntrepriseByNomResponse(nom:string): __Observable<__StrictHttpResponse<EntrepriseDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/entreprises/${nom}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<EntrepriseDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher une entreprise par son nom
   * @return Entreprise retrouvée dans la base de données
   */
  findEntrepriseByNom(nom:string): __Observable<EntrepriseDto> {
    return this.findEntrepriseByNomResponse(nom).pipe(
      __map(_r => _r.body as EntrepriseDto)
    );
  }

  /**
   * @return successful operation
   */
  findAll_4Response(): __Observable<__StrictHttpResponse<Array<FournisseurDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/forunisseurs`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<FournisseurDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findAll_4(): __Observable<Array<FournisseurDto>> {
    return this.findAll_4Response().pipe(
      __map(_r => _r.body as Array<FournisseurDto>)
    );
  }

  /**
   * @return successful operation
   */
  findById_3Response(id:number): __Observable<__StrictHttpResponse<FournisseurDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/forunisseurs/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<FournisseurDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findById_3(id:number): __Observable<FournisseurDto> {
    return this.findById_3Response(id).pipe(
      __map(_r => _r.body as FournisseurDto)
    );
  }
  deleteResponse(id:number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api2/forunisseurs/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<null>;
      })
    );
  }  delete(id:number): __Observable<null> {
    return this.deleteResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }

  /**
   * @return successful operation
   */
  mouvementStockArticleResponse(idArticle:number): __Observable<__StrictHttpResponse<Array<MouvementStockDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/mouvementstock/filter/article/${idArticle}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<MouvementStockDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  mouvementStockArticle(idArticle:number): __Observable<Array<MouvementStockDto>> {
    return this.mouvementStockArticleResponse(idArticle).pipe(
      __map(_r => _r.body as Array<MouvementStockDto>)
    );
  }

  /**
   * @return successful operation
   */
  sortieStockResponse(): __Observable<__StrictHttpResponse<MouvementStockDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/mouvementstock/sortie`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<MouvementStockDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  sortieStock(): __Observable<MouvementStockDto> {
    return this.sortieStockResponse().pipe(
      __map(_r => _r.body as MouvementStockDto)
    );
  }

  /**
   * @return successful operation
   */
  savePhotoResponse(id:number,title:string,context:string): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/photos/${id}/${title}/${context}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<{}>;
      })
    );
  }
  /**
   * @return successful operation
   */
  savePhoto(id:number,title:string,context:string): __Observable<{}> {
    return this.savePhotoResponse(id,title,context).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @return successful operation
   */
  findAll_5Response(): __Observable<__StrictHttpResponse<Array<RolesDto>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/roles`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<RolesDto>>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findAll_5(): __Observable<Array<RolesDto>> {
    return this.findAll_5Response().pipe(
      __map(_r => _r.body as Array<RolesDto>)
    );
  }
  save_4Response(): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api2/roles`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<null>;
      })
    );
  }  save_4(): __Observable<null> {
    return this.save_4Response().pipe(
      __map(_r => _r.body as null)
    );
  }

  /**
   * @return successful operation
   */
  findById_4Response(id:number): __Observable<__StrictHttpResponse<RolesDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/roles/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<RolesDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findById_4(id:number): __Observable<RolesDto> {
    return this.findById_4Response(id).pipe(
      __map(_r => _r.body as RolesDto)
    );
  }

  /**
   * @return successful operation
   */
  findSousCategorieByCodeResponse(code:string): __Observable<__StrictHttpResponse<SousCategorieDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/sousCategories/${code}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<SousCategorieDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findSousCategorieByCode(code:string): __Observable<SousCategorieDto> {
    return this.findSousCategorieByCodeResponse(code).pipe(
      __map(_r => _r.body as SousCategorieDto)
    );
  }

  /**
   * Cette methode permet d'enregistrer un utilisateur
   * @return Utilisateur créee avec succès
   */
  save_5Response(): __Observable<__StrictHttpResponse<UsersDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'POST',
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
        return _r as __StrictHttpResponse<UsersDto>;
      })
    );
  }
  /**
   * Cette methode permet d'enregistrer un utilisateur
   * @return Utilisateur créee avec succès
   */
  save_5(): __Observable<UsersDto> {
    return this.save_5Response().pipe(
      __map(_r => _r.body as UsersDto)
    );
  }

  /**
   * Cette methode permet de rechercher un utilisateur par son email
   * @return Utilisateur a été retrouvé dans la BD
   */
  findByEmailResponse(email:string): __Observable<__StrictHttpResponse<UsersDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/users/find/${email}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<UsersDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher un utilisateur par son email
   * @return Utilisateur a été retrouvé dans la BD
   */
  findByEmail(email:string): __Observable<UsersDto> {
    return this.findByEmailResponse(email).pipe(
      __map(_r => _r.body as UsersDto)
    );
  }

  /**
   * Cette methode permet de rechercher un utilisateur par son id
   * @return Utilisateur a été retrouvé dans la BD
   */
  findById_5Response(id:number): __Observable<__StrictHttpResponse<UsersDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/users/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<UsersDto>;
      })
    );
  }
  /**
   * Cette methode permet de rechercher un utilisateur par son id
   * @return Utilisateur a été retrouvé dans la BD
   */
  findById_5(id:number): __Observable<UsersDto> {
    return this.findById_5Response(id).pipe(
      __map(_r => _r.body as UsersDto)
    );
  }
  delete_1Response(id:number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api2/users/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<null>;
      })
    );
  }  delete_1(id:number): __Observable<null> {
    return this.delete_1Response(id).pipe(
      __map(_r => _r.body as null)
    );
  }

  /**
   * @return successful operation
   */
  findById_6Response(id:number): __Observable<__StrictHttpResponse<VenteDto>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api2/ventes/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<VenteDto>;
      })
    );
  }
  /**
   * @return successful operation
   */
  findById_6(id:number): __Observable<VenteDto> {
    return this.findById_6Response(id).pipe(
      __map(_r => _r.body as VenteDto)
    );
  }
}

module ApiService {
}

export { ApiService }
