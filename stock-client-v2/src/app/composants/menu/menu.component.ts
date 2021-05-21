import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from './menu';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  public menuProperties:Array<Menu>= [
    {
    id:'1',
    title:'Tableau de bord',
    icone:'fas fa-chart-line',
    url:'',
    sousMenu:[
      {
        id:'11',
        title:'Vue d\'ensemble',
        icone:'fas fa-eye',
        url:''
      },
      {
        id:'12',
        title:'Statistiques',
        icone:'far fa-chart-bar',
        url:'statistiques'
      }
    ]
  },

  {
    id:'2',
    title:'Articles',
    icone:'fas fa-boxes',
    url:'',
    sousMenu:[
      {
        id:'21',
        title:'Articles',
        icone:'fas fa-boxes',
        url:'articles'
      },
      {
        id:'22',
        title:'Mouvement du stock',
        icone:'fab fa-stack-overflow',
        url:'mouvementstock'
      }
    ]
  },

  {
    id:'3',
    title:'Clients',
    icone:'fas fa-users',
    url:'',
    sousMenu:[
      {
        id:'31',
        title:'Clients',
        icone:'fas fa-users',
        url:'clients'
      },
      {
        id:'32',
        title:'Commandes clients',
        icone:'fas fa-shopping-cart',
        url:'commandesclient'
      }
    ]
  },

  {
    id:'4',
    title:'Fournisseurs',
    icone:'fas fa-users',
    url:'',
    sousMenu:[
      {
        id:'41',
        title:'Fournisseurs',
        icone:'fas fa-users',
        url:'fournisseurs'
      },
      {
        id:'42',
        title:'Commandes fournisseurs',
        icone:'fas fa-truck-moving',
        url:'commandesfournisseur'
      }
    ]
  },

  {
    id:'5',
    title:'Paramètrages',
    icone:'fas fa-cog',
    url:'',
    sousMenu:[
      {
        id:'51',
        title:'Catégories',
        icone:'fas fa-layer-group',
        url:'categories'
      },
      {
        id:'52',
        title:'Utilisateurs',
        icone:'fas fa-users',
        url:'utilisateurs'
      }
    ]
  }
];

private lastSelectedMenu:Menu|undefined;

  constructor( private router:Router) { }

  ngOnInit(): void {
  }

  /* navigate(url?:string):void{
    this.router.navigate([url]);
  } */

  navigate(menu:Menu):void{
   if (this.lastSelectedMenu) {
     this.lastSelectedMenu.active=false;
   }
   menu.active=true;
   this.lastSelectedMenu=menu;
   this.router.navigate([menu.url]);
  }

}
