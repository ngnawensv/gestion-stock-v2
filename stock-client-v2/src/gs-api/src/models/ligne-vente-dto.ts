/* tslint:disable */
import { ArticleDto } from './article-dto';
import { VenteDto } from './vente-dto';
export interface LigneVenteDto {
  id?: number;
  article?: ArticleDto;
  vente?: VenteDto;
  quantite?: number;
  prixUniataire?: number;
  entrepriseId?: number;
}
