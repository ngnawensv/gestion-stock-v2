/* tslint:disable */
import { CategorieDto } from './categorie-dto';
export interface SousCategorieDto {
  id?: number;
  code?: string;
  libelle?: string;
  categorie?: CategorieDto;
  entrepriseId?: number;
}
