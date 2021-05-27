/* tslint:disable */
import { AdresseDto } from './adresse-dto';
export interface EntrepriseDto {
  id?: number;
  codeFiscal?: string;
  nom?: string;
  email?: string;
  logo?: string;
  siteWeb?: string;
  numeroTelephone?: string;
  description?: string;
  adresse?: AdresseDto;
}
