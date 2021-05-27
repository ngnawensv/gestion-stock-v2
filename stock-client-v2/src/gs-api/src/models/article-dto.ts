/* tslint:disable */
import { CategorieDto } from './categorie-dto';
export interface ArticleDto {
  id?: number;
  code?: string;
  designation?: string;
  prixUnitaireHt?: number;
  tauxTva?: number;
  prixUnitaireTtc?: number;
  prixAchat?: number;
  prixVente?: number;
  quantite?: number;
  photo?: string;
  categorieDto?: CategorieDto;
  entrepriseId?: number;
}
