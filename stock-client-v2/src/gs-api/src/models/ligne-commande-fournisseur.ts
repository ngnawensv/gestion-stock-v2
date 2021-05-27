/* tslint:disable */
import { Article } from './article';
import { CommandeFournisseur } from './commande-fournisseur';
export interface LigneCommandeFournisseur {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  quantite?: number;
  prixUnitaire?: number;
  entrepriseId?: number;
  article?: Article;
  commandeFournisseur?: CommandeFournisseur;
}
