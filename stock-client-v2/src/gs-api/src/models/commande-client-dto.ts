/* tslint:disable */
import { Client } from './client';
export interface CommandeClientDto {
  id?: number;
  code?: string;
  dateCommande?: number;
  client?: Client;
  etatCommande?: 'LIVREE' | 'VALIDEE' | 'EN_COURS';
  entrepriseId?: number;
  commandeLivree?: boolean;
}
