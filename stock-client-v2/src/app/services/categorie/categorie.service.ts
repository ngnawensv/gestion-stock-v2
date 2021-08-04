import { CategorieDto } from './../../../gs-api/src/models/categorie-dto';
import { Injectable } from '@angular/core';
import { Api2categoriesService } from 'src/gs-api/src/services';
import { UserService } from '../user/user.service';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  categorieDto: CategorieDto = {};

  constructor(
    private userService: UserService,
    private api2CategorieService:Api2categoriesService

  ) { }

  saveCategorie(categorieDto: CategorieDto): Observable<CategorieDto>{
    this.categorieDto.entrepriseId = this.userService.getConnectedUser().id;
    return this.api2CategorieService.save(categorieDto);

  }

  findByid(idCategorie:number): Observable<CategorieDto>{
    return this.api2CategorieService.findById(idCategorie)
  }

  findAll(): Observable<CategorieDto[]>{
    return this.api2CategorieService.findAll();
  }

  deleteCategorie(id?: number): Observable<any>{
    console.log(id);
    if (id) {
      return this.api2CategorieService.delete(id)
    }
    return of();
  }
}
