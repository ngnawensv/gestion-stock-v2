import {Categorie} from "./categorie";

export class Article {
  id: number;
  nom: string;
  prixAchat:number;
  prixVente:number;
  quantite:number;
  categorie: Categorie;
}
