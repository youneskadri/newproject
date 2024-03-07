import { TestBed } from '@angular/core/testing';

import { LigneOffreService } from './ligne-offre.service';

describe('LigneOffreService', () => {
  let service: LigneOffreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LigneOffreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
