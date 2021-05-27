/* tslint:disable */
import { ArticleDto } from './article-dto';
import { CommandeFournisseurDto } from './commande-fournisseur-dto';
export interface LigneCommandeFournisseurDto {
  id?: number;
  article?: ArticleDto;
  commandeFournisseur?: CommandeFournisseurDto;
  entrepriseId?: number;
}
