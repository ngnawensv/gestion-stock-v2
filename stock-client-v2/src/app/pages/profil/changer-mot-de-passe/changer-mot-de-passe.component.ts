import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Api2categoriesService } from 'src/gs-api/src/services';

@Component({
  selector: 'app-changer-mot-de-passe',
  templateUrl: './changer-mot-de-passe.component.html',
  styleUrls: ['./changer-mot-de-passe.component.scss']
})
export class ChangerMotDePasseComponent implements OnInit {

  constructor(
    private utili:Api2categoriesService,
    private route:Router
    ) { }

  ngOnInit(): void {
    this.utili.findAll().subscribe(res=>{

    })
  }

  cancelClick():void{
    this.route.navigate(['profil'])
  }

}
