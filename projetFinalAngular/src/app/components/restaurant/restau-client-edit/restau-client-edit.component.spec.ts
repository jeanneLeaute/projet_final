import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestauClientEditComponent } from './restau-client-edit.component';

describe('RestauClientEditComponent', () => {
  let component: RestauClientEditComponent;
  let fixture: ComponentFixture<RestauClientEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestauClientEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestauClientEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
