/* tslint:disable */
import { AdresseDto } from './adresse-dto';
export interface FournisseurDto {
  id?: number;
  nom?: string;
  prenom?: string;
  genre?: string;
  dateNaissance?: number;
  lieuNaissance?: string;
  email?: string;
  numTel?: string;
  photo?: string;
  adresse?: AdresseDto;
  entrepriseId?: number;
}
