import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestauReservationComponent } from './restau-reservation.component';

describe('RestauReservationComponent', () => {
  let component: RestauReservationComponent;
  let fixture: ComponentFixture<RestauReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestauReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestauReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
