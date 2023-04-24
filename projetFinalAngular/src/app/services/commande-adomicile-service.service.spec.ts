import { TestBed } from '@angular/core/testing';

import { CommandeADomicileService } from './commande-adomicile.service';

describe('CommandeADomicileServiceService', () => {
  let service: CommandeADomicileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommandeADomicileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
