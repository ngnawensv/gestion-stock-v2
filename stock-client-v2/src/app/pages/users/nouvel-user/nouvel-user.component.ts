import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nouvel-user',
  templateUrl: './nouvel-user.component.html',
  styleUrls: ['./nouvel-user.component.scss']
})
export class NouvelUserComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  cancelClik():void{
    this.route.navigate(['utilisateurs'])
  }

}
