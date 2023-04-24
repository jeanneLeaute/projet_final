import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationSurPlaceComponent } from './reservation-sur-place.component';

describe('ReservationSurPlaceComponent', () => {
  let component: ReservationSurPlaceComponent;
  let fixture: ComponentFixture<ReservationSurPlaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationSurPlaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReservationSurPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
