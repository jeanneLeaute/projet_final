import { TestBed } from '@angular/core/testing';

import { SurPlaceService } from './sur-place.service';

describe('SurPlaceServiceService', () => {
  let service: SurPlaceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurPlaceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
