import { TestBed } from '@angular/core/testing';

import { EditRestaurantGuardService } from './edit-restaurant-guard.service';

describe('EditRestaurantGuardService', () => {
  let service: EditRestaurantGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditRestaurantGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
