import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {HomeComponent} from "./home/home.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {TranslateModule, TranslateService} from "@ngx-translate/core";
import {authInterceptorProviders} from "./_helpers/auth.interceptor";
import {initApp} from "./_i18nutils/initApp";
import { AdminComponent } from './admin/admin.component';
import { ArticleComponent } from './article/article.component';
import { ParametreComponent } from './parametre/parametre.component';
import { CategorieComponent } from './categorie/categorie.component';
import { AddCategorieComponent } from './add-categorie/add-categorie.component';
import {DataTablesModule} from "angular-datatables";
import { UpdateCategorieComponent } from './update-categorie/update-categorie.component';
import { AddArticleComponent } from './add-article/add-article.component';
import { EditCategorieComponent } from './edit-categorie/edit-categorie.component';
import { EditArticleComponent } from './edit-article/edit-article.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    ArticleComponent,
    ParametreComponent,
    CategorieComponent,
    AddCategorieComponent,
    UpdateCategorieComponent,
    AddArticleComponent,
    EditCategorieComponent,
    EditArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    DataTablesModule,
    ReactiveFormsModule,
    TranslateModule.forRoot() //Module import for i18n see https://levelup.gitconnected.com/angular-internationalization-i18n-with-ngx-translate-8f89005cb337
  ],
  providers: [
    {provide: APP_INITIALIZER, useFactory: initApp, deps: [HttpClient, TranslateService], multi: true},
    authInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

