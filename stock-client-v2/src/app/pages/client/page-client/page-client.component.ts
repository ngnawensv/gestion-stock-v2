import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-client',
  templateUrl: './page-client.component.html',
  styleUrls: ['./page-client.component.scss']
})
export class PageClientComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  nouvelClient():void{
    this.route.navigate(['nouvelclient'])
  }

}
