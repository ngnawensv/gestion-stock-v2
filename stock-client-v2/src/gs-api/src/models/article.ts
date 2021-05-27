/* tslint:disable */
import { Categorie } from './categorie';
import { LigneVente } from './ligne-vente';
import { LigneCommandeClient } from './ligne-commande-client';
import { LigneCommandeFournisseur } from './ligne-commande-fournisseur';
export interface Article {
  createdBy?: string;
  updatedBy?: string;
  createdDate?: string;
  updateDate?: string;
  id?: number;
  code?: string;
  designation?: string;
  prixUnitaireHt?: number;
  tauxTva?: number;
  prixUnitaireTtc?: number;
  photo?: string;
  entrepriseId?: number;
  categorie?: Categorie;
  ligneVentes?: Array<LigneVente>;
  ligneCommandeClients?: Array<LigneCommandeClient>;
  ligneCommandeFournisseurs?: Array<LigneCommandeFournisseur>;
}
