/* tslint:disable */
import { Fournisseur } from './fournisseur';
import { LigneCommandeFournisseur } from './ligne-commande-fournisseur';
export interface CommandeFournisseur {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  code?: string;
  dateCommande?: number;
  etatCommande?: 'LIVREE' | 'VALIDEE' | 'EN_COURS';
  fournisseur?: Fournisseur;
  ligneCommandeFournisseurList?: Array<LigneCommandeFournisseur>;
  entrepriseId?: number;
}
