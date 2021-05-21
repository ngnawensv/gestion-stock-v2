export interface Menu {
    id?: string;
    title?: string;
    icone?: string;
    url?: string;
    active?:boolean; //permet de savoir si le menu est active ou non
    sousMenu?: Array<Menu>

}
