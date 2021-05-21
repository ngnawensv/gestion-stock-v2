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
    children:[
      {
        path:'statistiques',
        component:PageStatistiquesComponent
      },
      {
        path:'articles',
        component:PageArticleComponent
      },
      {
        path:'nouvelarticle',
        component:NouvelArticleComponent
      },
      {
        path:'mouvementstock',
        component:PageMouvementStockComponent
      },
      {
        path:'clients',
        component:PageClientComponent
      },
      {
        path:'nouvelclient',
        component:NouveauClientFournisseurComponent,
        data:{
          origin:'client'
        }
      },
      {
        path:'commandesclient',
        component:PageCommandeClientFournisseurComponent,
        data:{
          origin:'client'
        }
      },
      {
        path:'nouvellecommandeclient',
        component:NouvelleCommandeClientFournisseurComponent,
        data:{
          origin:'client'
        }
      },
      {
        path:'fournisseurs',
        component:PageFournisseurComponent
      },
      {
        path:'nouvelfournisseur',
        component:NouveauClientFournisseurComponent,
        data:{
          origin:'fournisseur'
        }
      },
      {
        path:'commandesfournisseur',
        component:PageCommandeClientFournisseurComponent,
        data:{
          origin:'fournisseur'
        }
      },
      {
        path:'nouvellecommandefournisseur',
        component:NouvelleCommandeClientFournisseurComponent,
        data:{
          origin:'fournisseur'
        }
      },
      {
        path:'categories',
        component:PageCategoriesComponent
      },
      {
        path:'nouvellecategorie',
        component:NouvelleCategorieComponent
      },
      {
        path:'utilisateurs',
        component:PageUserComponent
      },
      {
        path:'nouveluser',
        component:NouvelUserComponent
      },
      {
        path:'profil',
        component:PageProfilComponent
      },
      {
        path:'changermotdepasse',
        component:ChangerMotDePasseComponent
      }

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
