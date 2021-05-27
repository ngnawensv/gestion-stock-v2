/* tslint:disable */
import { ArticleDto } from './article-dto';
export interface MouvementStockDto {
  id?: number;
  article?: ArticleDto;
  quantite?: number;
  dateMouvement?: number;
  typeMouvementStock?: 'SORTIE' | 'ENTREE' | 'CORRECTION_POS' | 'CORRECTION_NEG';
  sourceMouvementStock?: 'COMMANDE_CLIENT' | 'COMMANDE_FOURNISSEUR' | 'VENTE';
  entrepriseId?: number;
}
