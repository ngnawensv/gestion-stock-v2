import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthGuard} from "./_helpers/auth.guard";
import {AdminComponent} from "./admin/admin.component";
import {ArticleComponent} from "./article/article.component";
import {ParametreComponent} from "./parametre/parametre.component";
import {CategorieComponent} from "./categorie/categorie.component";
import {AddCategorieComponent} from "./add-categorie/add-categorie.component";
import {UpdateCategorieComponent} from "./update-categorie/update-categorie.component";
import {AddArticleComponent} from "./add-article/add-article.component";
import {EditCategorieComponent} from "./edit-categorie/edit-categorie.component";
import {EditArticleComponent} from "./edit-article/edit-article.component";


/**
 * We configure the Routing for our Angular app in app-routing.module.ts.
 */
const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'admin', component: AdminComponent,canActivate:[AuthGuard] },//Association de AuthGuard a la route admin
  { path: 'article', component: ArticleComponent,canActivate:[AuthGuard] },
  { path: 'parametre', component: ParametreComponent,canActivate:[AuthGuard] },//Association de AuthGuard a la route admin
  { path: 'categories', component: CategorieComponent,canActivate:[AuthGuard] },
  { path: 'categories/add', component: AddCategorieComponent,canActivate:[AuthGuard] },
  { path: 'categories/edit/:id', component: EditCategorieComponent,canActivate:[AuthGuard] },
  { path: 'articles', component: ArticleComponent,canActivate:[AuthGuard] },
  { path: 'articles/add', component: AddArticleComponent,canActivate:[AuthGuard] },
  { path: 'articles/edit/:id', component: EditArticleComponent,canActivate:[AuthGuard] },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
