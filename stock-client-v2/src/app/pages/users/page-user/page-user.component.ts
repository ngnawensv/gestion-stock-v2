import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-user',
  templateUrl: './page-user.component.html',
  styleUrls: ['./page-user.component.scss']
})
export class PageUserComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  nouvelUser():void {
    this.route.navigate(['nouveluser']);
  }

}
