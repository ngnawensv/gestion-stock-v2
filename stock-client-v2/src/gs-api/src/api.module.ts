/* tslint:disable */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationInterface } from './api-configuration';

import { ApiService } from './services/api.service';
import { Api2articlesService } from './services/api-2articles.service';
import { Api2authenticateService } from './services/api-2authenticate.service';
import { Api2categoriesService } from './services/api-2categories.service';
import { Api2clientsService } from './services/api-2clients.service';
import { Api2commandesFournisseursService } from './services/api-2commandes-fournisseurs.service';
import { Api2commandesclientsService } from './services/api-2commandesclients.service';
import { Api2entreprisesService } from './services/api-2entreprises.service';
import { Api2fournisseursService } from './services/api-2fournisseurs.service';
import { Api2mouvementstockService } from './services/api-2mouvementstock.service';
import { Api2rolesService } from './services/api-2roles.service';
import { Api2souscategoriesService } from './services/api-2souscategories.service';
import { Api2usersService } from './services/api-2users.service';
import { Api2ventesService } from './services/api-2ventes.service';

/**
 * Provider for all Api services, plus ApiConfiguration
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
    ApiService,
    Api2articlesService,
    Api2authenticateService,
    Api2categoriesService,
    Api2clientsService,
    Api2commandesFournisseursService,
    Api2commandesclientsService,
    Api2entreprisesService,
    Api2fournisseursService,
    Api2mouvementstockService,
    Api2rolesService,
    Api2souscategoriesService,
    Api2usersService,
    Api2ventesService
  ],
})
export class ApiModule {
  static forRoot(customParams: ApiConfigurationInterface): ModuleWithProviders {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: {rootUrl: customParams.rootUrl}
        }
      ]
    }
  }
}
