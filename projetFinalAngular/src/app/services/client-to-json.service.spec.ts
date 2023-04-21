import { TestBed } from '@angular/core/testing';

import { ClientToJsonService } from './client-to-json.service';

describe('ClientToJsonService', () => {
  let service: ClientToJsonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientToJsonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
