/* tslint:disable */
import { Article } from './article';
import { CommandeClient } from './commande-client';
export interface LigneCommandeClient {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  quantite?: number;
  prixUnitaire?: number;
  article?: Article;
  commandeClient?: CommandeClient;
  entrepriseId?: number;
}
