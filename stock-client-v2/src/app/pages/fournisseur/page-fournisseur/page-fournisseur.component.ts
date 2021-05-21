import { Component, OnInit } from '@angular/core';
import { Router, RouteReuseStrategy } from '@angular/router';

@Component({
  selector: 'app-page-fournisseur',
  templateUrl: './page-fournisseur.component.html',
  styleUrls: ['./page-fournisseur.component.scss']
})
export class PageFournisseurComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  nouvelFournisseur():void{
    this.route.navigate(['nouvelfournisseur'])
  }

}
