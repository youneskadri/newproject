import { TestBed } from '@angular/core/testing';

import { OffreFournisseurService } from './offre-fournisseur.service';

describe('OffreFournisseurService', () => {
  let service: OffreFournisseurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OffreFournisseurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
