import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-page-commande-client-fournisseur',
  templateUrl: './page-commande-client-fournisseur.component.html',
  styleUrls: ['./page-commande-client-fournisseur.component.scss']
})
export class PageCommandeClientFournisseurComponent implements OnInit {

  origin = '';
  constructor(
    private route: Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data => {
      this.origin = data.origin;
    })
  }

  nouvelleCommande(): void {
    if (this.origin === 'client') {
      this.route.navigate(['nouvellecommandeclient'])
    } else if (this.origin === 'fournisseur') {
      this.route.navigate(['nouvellecommandefournisseur'])
    }
  }

}
