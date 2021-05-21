import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-nouveau-client-fournisseur',
  templateUrl: './nouveau-client-fournisseur.component.html',
  styleUrls: ['./nouveau-client-fournisseur.component.scss'],
})
export class NouveauClientFournisseurComponent implements OnInit {
  origin = '';

  constructor(private route: Router, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe((data) => {
      this.origin = data.origin;
    });
  }

  cancelClick(): void {
    if (this.origin === 'client') {
      this.route.navigate(['clients']);
    } else if (this.origin === 'fournisseur') {
      this.route.navigate(['fournisseurs']);
    }
  }

  saveClick(): void {}
}
