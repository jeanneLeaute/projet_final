import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionRestaurateurComponent } from './inscription-restaurateur.component';

describe('InscriptionRestaurateurComponent', () => {
  let component: InscriptionRestaurateurComponent;
  let fixture: ComponentFixture<InscriptionRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InscriptionRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
