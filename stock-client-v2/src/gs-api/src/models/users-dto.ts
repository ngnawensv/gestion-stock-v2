/* tslint:disable */
import { AdresseDto } from './adresse-dto';
import { EntrepriseDto } from './entreprise-dto';
import { RolesDto } from './roles-dto';
export interface UsersDto {
  id?: number;
  username?: string;
  email?: string;
  password?: string;
  nom?: string;
  prenom?: string;
  dateNaissance?: number;
  genre?: string;
  photo?: string;
  adresse?: AdresseDto;
  entreprise?: EntrepriseDto;
  roles?: Array<RolesDto>;
}
