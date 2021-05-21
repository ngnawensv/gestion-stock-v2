import { Component, OnInit, Output ,EventEmitter, Input} from '@angular/core';

@Component({
  selector: 'app-bouton-action',
  templateUrl: './bouton-action.component.html',
  styleUrls: ['./bouton-action.component.scss']
})
export class BoutonActionComponent implements OnInit {

  @Input()//specifie que l'evenement est envoyé au composant fils par le composant parents
  isNouveauVisible=true;
  @Input()
  isExportVisible=true;
  @Input()
  isImportVisible=true;

  @Output() //specifie que l'evenement est envoyé au composant parent par le composant fils
  clickEvent=new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  boutonNouveauClient(): void{
    this.clickEvent.emit();
  }

}
