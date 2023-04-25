import { TestBed } from '@angular/core/testing';

import { ItemMenuService } from './item-menu.service';

describe('ItemMenuService', () => {
  let service: ItemMenuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemMenuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
