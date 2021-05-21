import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageLoginComponent } from './pages/page-login/page-login.component';
import { PageInscriptionComponent } from './pages/page-inscription/page-inscription.component';
import { PageDashboardComponent } from './pages/page-dashboard/page-dashboard.component';
import { PageStatistiquesComponent } from './pages/page-statistiques/page-statistiques.component';
import { MenuComponent } from './composants/menu/menu.component';
import { HeaderComponent } from './header/header.component';
import { PageArticleComponent } from './pages/articles/page-article/page-article.component';
import { DetailArticleComponent } from './composants/detail-article/detail-article.component';
import { PaginationComponent } from './composants/pagination/pagination.component';
import { BoutonActionComponent } from './composants/bouton-action/bouton-action.component';
import { NouvelArticleComponent } from './pages/articles/nouvel-article/nouvel-article.component';
import { PageMouvementStockComponent } from './pages/mouvement-stock/page-mouvement-stock/page-mouvement-stock.component';
import { DetailMouvementStockArticleComponent } from './composants/detail-mouvement-stock-article/detail-mouvement-stock-article.component';
import { DetailMouvementStockComponent } from './composants/detail-mouvement-stock/detail-mouvement-stock.component';
import { DetailsClientFournisseurComponent } from './composants/details-client-fournisseur/details-client-fournisseur.component';
import { PageClientComponent } from './pages/client/page-client/page-client.component';
import { PageFournisseurComponent } from './pages/fournisseur/page-fournisseur/page-fournisseur.component';
import { NouveauClientFournisseurComponent } from './composants/nouveau-client-fournisseur/nouveau-client-fournisseur.component';
import { DetailCommandeClientFournisseurComponent } from './composants/detail-commande-client-fournisseur/detail-commande-client-fournisseur.component';
import { DetailCommandeComponent } from './composants/detail-commande/detail-commande.component';
import { PageCommandeClientFournisseurComponent } from './pages/page-commande-client-fournisseur/page-commande-client-fournisseur.component';
import { NouvelleCommandeClientFournisseurComponent } from './composants/nouvelle-commande-client-fournisseur/nouvelle-commande-client-fournisseur.component';
import { PageCategoriesComponent } from './pages/categories/page-categories/page-categories.component';
import { PageUserComponent } from './pages/users/page-user/page-user.component';
import { DetailUserComponent } from './composants/detail-user/detail-user.component';
import { NouvelUserComponent } from './pages/users/nouvel-user/nouvel-user.component';
import { NouvelleCategorieComponent } from './pages/categories/nouvelle-categorie/nouvelle-categorie.component';
import { PageProfilComponent } from './pages/profil/page-profil/page-profil.component';
import { ChangerMotDePasseComponent } from './pages/profil/changer-mot-de-passe/changer-mot-de-passe.component';

@NgModule({
  declarations: [
    AppComponent,
    PageLoginComponent,
    PageInscriptionComponent,
    PageDashboardComponent,
    PageStatistiquesComponent,
    MenuComponent,
    HeaderComponent,
    PageArticleComponent,
    DetailArticleComponent,
    PaginationComponent,
    BoutonActionComponent,
    NouvelArticleComponent,
    PageMouvementStockComponent,
    DetailMouvementStockArticleComponent,
    DetailMouvementStockComponent,
    DetailsClientFournisseurComponent,
    PageClientComponent,
    PageFournisseurComponent,
    NouveauClientFournisseurComponent,
    DetailCommandeClientFournisseurComponent,
    DetailCommandeComponent,
    PageCommandeClientFournisseurComponent,
    NouvelleCommandeClientFournisseurComponent,
    PageCategoriesComponent,
    PageUserComponent,
    DetailUserComponent,
    NouvelUserComponent,
    NouvelleCategorieComponent,
    PageProfilComponent,
    ChangerMotDePasseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
