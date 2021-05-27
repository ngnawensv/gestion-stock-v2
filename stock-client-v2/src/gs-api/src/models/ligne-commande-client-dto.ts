/* tslint:disable */
import { ArticleDto } from './article-dto';
import { CommandeClientDto } from './commande-client-dto';
export interface LigneCommandeClientDto {
  id?: number;
  article?: ArticleDto;
  quantite?: number;
  prixUnitaire?: number;
  commandeClient?: CommandeClientDto;
  entrepriseId?: number;
}
