/* tslint:disable */
import { Client } from './client';
import { LigneCommandeClient } from './ligne-commande-client';
export interface CommandeClient {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  code?: string;
  dateCommande?: number;
  etatCommande?: 'LIVREE' | 'VALIDEE' | 'EN_COURS';
  entrepriseId?: number;
  client?: Client;
  ligneCommandeClients?: Array<LigneCommandeClient>;
}
