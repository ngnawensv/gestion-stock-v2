/* tslint:disable */
import { Article } from './article';
import { Vente } from './vente';
export interface LigneVente {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  quantite?: number;
  prixUniataire?: number;
  entrepriseId?: number;
  article?: Article;
  vente?: Vente;
}
