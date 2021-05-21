import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-categories',
  templateUrl: './page-categories.component.html',
  styleUrls: ['./page-categories.component.scss']
})
export class PageCategoriesComponent implements OnInit {

  constructor(private route:Router){ }

  ngOnInit(): void {
  }

  nouvelleCategorie():void{
    this.route.navigate(['nouvellecategorie']);
  }

}
