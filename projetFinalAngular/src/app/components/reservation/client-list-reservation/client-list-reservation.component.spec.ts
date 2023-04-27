import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientListReservationComponent } from './client-list-reservation.component';

describe('ClientListReservationComponent', () => {
  let component: ClientListReservationComponent;
  let fixture: ComponentFixture<ClientListReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientListReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientListReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
