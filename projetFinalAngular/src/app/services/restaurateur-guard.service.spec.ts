import { TestBed } from '@angular/core/testing';

import { RestaurateurGuardService } from './restaurateur-guard.service';

describe('RestaurateurGuardService', () => {
  let service: RestaurateurGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurateurGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
