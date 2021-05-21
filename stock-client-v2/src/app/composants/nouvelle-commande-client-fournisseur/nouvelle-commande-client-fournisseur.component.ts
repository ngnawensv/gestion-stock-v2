import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-nouvelle-commande-client-fournisseur',
  templateUrl: './nouvelle-commande-client-fournisseur.component.html',
  styleUrls: ['./nouvelle-commande-client-fournisseur.component.scss']
})
export class NouvelleCommandeClientFournisseurComponent implements OnInit {

  origin='';

  constructor(
    private activatedRoute:ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data=>{
      this.origin= data.origin;
     })
  }

}
