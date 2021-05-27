/* tslint:disable */
import { Adresse } from './adresse';
import { CommandeClient } from './commande-client';
export interface Client {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  nom?: string;
  prenom?: string;
  genre?: string;
  dateNaissance?: string;
  lieuNaissance?: string;
  email?: string;
  numeroTelephone?: string;
  photo?: string;
  adresse?: Adresse;
  entrepriseId?: number;
  commandeClientList?: Array<CommandeClient>;
}
