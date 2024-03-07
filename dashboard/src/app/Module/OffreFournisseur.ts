import { StatutOffre } from "./StatutOffre";
import { Proposition } from "./proposition";

export class OffreFournisseur {
    idOffre!: number;
    titre!: string;
    status!:StatutOffre; 
    prposition!:Proposition;
    static baseUrl: string;

  }