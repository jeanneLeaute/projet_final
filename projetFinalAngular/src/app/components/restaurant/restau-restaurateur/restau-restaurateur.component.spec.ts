import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestauRestaurateurComponent } from './restau-restaurateur.component';

describe('RestauRestaurateurComponent', () => {
  let component: RestauRestaurateurComponent;
  let fixture: ComponentFixture<RestauRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestauRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestauRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
