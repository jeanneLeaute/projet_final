import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoncompteRestaurateurComponent } from './moncompte-restaurateur.component';

describe('MoncompteRestaurateurComponent', () => {
  let component: MoncompteRestaurateurComponent;
  let fixture: ComponentFixture<MoncompteRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoncompteRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MoncompteRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
