import { TestBed } from '@angular/core/testing';

import { RestaurateurService } from './restaurateur.service';

describe('RestaurateurService', () => {
  let service: RestaurateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
