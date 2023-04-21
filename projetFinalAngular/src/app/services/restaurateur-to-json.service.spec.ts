import { TestBed } from '@angular/core/testing';

import { RestaurateurToJsonService } from './restaurateur-to-json.service';

describe('RestaurateurToJsonService', () => {
  let service: RestaurateurToJsonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurateurToJsonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
