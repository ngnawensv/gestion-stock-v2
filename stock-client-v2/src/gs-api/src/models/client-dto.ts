/* tslint:disable */
import { AdresseDto } from './adresse-dto';
export interface ClientDto {
  id?: number;
  nom?: string;
  prenom?: string;
  genre?: string;
  dateNaissance?: string;
  lieuNaissance?: string;
  email?: string;
  numTel?: string;
  photo?: string;
  adresse?: AdresseDto;
  entrepriseId?: number;
}
