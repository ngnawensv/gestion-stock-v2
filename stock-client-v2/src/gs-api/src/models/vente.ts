/* tslint:disable */
import { LigneVente } from './ligne-vente';
export interface Vente {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  code?: string;
  dateVente?: number;
  commentaire?: string;
  entrepriseId?: number;
  ligneVenteList?: Array<LigneVente>;
}
