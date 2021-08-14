import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageArticleComponent } from './pages/articles/page-article/page-article.component';
import { PageDashboardComponent } from './pages/page-dashboard/page-dashboard.component';
import { PageInscriptionComponent } from './pages/page-inscription/page-inscription.component';
import { PageLoginComponent } from './pages/page-login/page-login.component';
import { PageStatistiquesComponent } from './pages/page-statistiques/page-statistiques.component';
import { NouvelArticleComponent } from './pages/articles/nouvel-article/nouvel-article.component';
import { DetailMouvementStockArticleComponent } from './composants/detail-mouvement-stock-article/detail-mouvement-stock-article.component';
import { PageMouvementStockComponent } from './pages/mouvement-stock/page-mouvement-stock/page-mouvement-stock.component';
import { PageClientComponent } from './pages/client/page-client/page-client.component';
import { PageFournisseurComponent } from './pages/fournisseur/page-fournisseur/page-fournisseur.component';
import { NouveauClientFournisseurComponent } from './composants/nouveau-client-fournisseur/nouveau-client-fournisseur.component';
import { PageCommandeClientFournisseurComponent } from './pages/page-commande-client-fournisseur/page-commande-client-fournisseur.component';
import { NouvelleCommandeClientFournisseurComponent } from './composants/nouvelle-commande-client-fournisseur/nouvelle-commande-client-fournisseur.component';
import { PageCategoriesComponent } from './pages/categories/page-categories/page-categories.component';
import { PageUserComponent } from './pages/users/page-user/page-user.component';
import { NouvelUserComponent } from './pages/users/nouvel-user/nouvel-user.component';
import { NouvelleCategorieComponent } from './pages/categories/nouvelle-categorie/nouvelle-categorie.component';
import { PageProfilComponent } from './pages/profil/page-profil/page-profil.component';
import { ChangerMotDePasseComponent } from './pages/profil/changer-mot-de-passe/changer-mot-de-passe.component';
import { ApplicationGuardService } from './services/guard/application-guard.service';

const routes: Routes = [
  {
    path : 'login',
    component : PageLoginComponent
  },
  {
    path : 'inscrire',
    component : PageInscriptionComponent
  },
  {
    path : '',
    component : PageDashboardComponent,
    canActivate:[ApplicationGuardService],
    children:[
      {
        path:'statistiques',
        component:PageStatistiquesComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'articles',
        component:PageArticleComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'nouvelarticle',
        component:NouvelArticleComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'nouvelarticle/:idArticle',
        component:NouvelArticleComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'mouvementstock',
        component:PageMouvementStockComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'clients',
        component:PageClientComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'nouvelclient',
        component:NouveauClientFournisseurComponent,
        canActivate:[ApplicationGuardService],
        data:{
          origin:'client'
        }
      },
      {
        path:'commandesclient',
        component:PageCommandeClientFournisseurComponent,
        canActivate:[ApplicationGuardService],
        data:{
          origin:'client'
        }
      },
      {
        path:'nouvellecommandeclient',
        component:NouvelleCommandeClientFournisseurComponent,
        canActivate:[ApplicationGuardService],
        data:{
          origin:'client'
        }
      },
      {
        path:'fournisseurs',
        component:PageFournisseurComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'nouvelfournisseur',
        component:NouveauClientFournisseurComponent,
        canActivate:[ApplicationGuardService],
        data:{
          origin:'fournisseur'
        }
      },
      {
        path:'commandesfournisseur',
        component:PageCommandeClientFournisseurComponent,
        canActivate:[ApplicationGuardService],
        data:{
          origin:'fournisseur'
        }
      },
      {
        path:'nouvellecommandefournisseur',
        component:NouvelleCommandeClientFournisseurComponent,
        canActivate:[ApplicationGuardService],
        data:{
          origin:'fournisseur'
        }
      },
      {
        path:'categories',
        component:PageCategoriesComponent,
        canActivate:[ApplicationGuardService]
      },
      {//This path is use to create a new categorie
        path:'nouvellecategorie',
        component:NouvelleCategorieComponent,
        canActivate:[ApplicationGuardService]
      },
      {//This path is use to modified a category with idCategorie
        path:'nouvellecategorie/:idCategorie',
        component:NouvelleCategorieComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'utilisateurs',
        component:PageUserComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'nouveluser',
        component:NouvelUserComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'profil',
        component:PageProfilComponent,
        canActivate:[ApplicationGuardService]
      },
      {
        path:'changermotdepasse',
        component:ChangerMotDePasseComponent,
        canActivate:[ApplicationGuardService]
      }

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
