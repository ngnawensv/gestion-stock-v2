import { Injectable } from '@angular/core';
import { Api2entreprisesService } from 'src/gs-api/src/services';
import { EntrepriseDto } from '../../../gs-api/src/models/entreprise-dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {

  constructor( 
    private entrepriseSerice: Api2entreprisesService
    ) { }

  sinscrire(entrepriseDto: EntrepriseDto): Observable<EntrepriseDto>{
    return this.entrepriseSerice.save(entrepriseDto);
  }
}
