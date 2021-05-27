/* tslint:disable */
import { Fournisseur } from './fournisseur';
export interface CommandeFournisseurDto {
  id?: number;
  code?: string;
  dateCommande?: number;
  fournisseur?: Fournisseur;
  etatCommande?: 'LIVREE' | 'VALIDEE' | 'EN_COURS';
  entrepriseId?: number;
  commandeLivree?: boolean;
}
