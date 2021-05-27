/* tslint:disable */
import { Adresse } from './adresse';
import { CommandeFournisseur } from './commande-fournisseur';
export interface Fournisseur {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  nom?: string;
  prenom?: string;
  genre?: string;
  dateNaissance?: number;
  lieuNaissance?: string;
  email?: string;
  numeroTelephone?: string;
  photo?: string;
  adresse?: Adresse;
  entrepriseId?: number;
  commandeFournisseurs?: Array<CommandeFournisseur>;
}
