import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestauRestaurateurEditComponent } from './restau-restaurateur-edit.component';

describe('RestauRestaurateurEditComponent', () => {
  let component: RestauRestaurateurEditComponent;
  let fixture: ComponentFixture<RestauRestaurateurEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestauRestaurateurEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestauRestaurateurEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
