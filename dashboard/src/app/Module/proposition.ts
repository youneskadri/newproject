import { evenement } from "./evenement";

export class Proposition {
    id!: number;
    titre!: string;
    description!: string;
    evenement!:evenement; 
    static baseUrl: string;

  }