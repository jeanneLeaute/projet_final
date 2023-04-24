import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationCommandeADomicileComponent } from './reservation-commande-adomicile.component';

describe('ReservationCommandeADomicileComponent', () => {
  let component: ReservationCommandeADomicileComponent;
  let fixture: ComponentFixture<ReservationCommandeADomicileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationCommandeADomicileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReservationCommandeADomicileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
