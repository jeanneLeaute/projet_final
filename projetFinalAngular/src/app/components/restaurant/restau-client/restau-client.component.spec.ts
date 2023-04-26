import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestauClientComponent } from './restau-client.component';

describe('RestauClientComponent', () => {
  let component: RestauClientComponent;
  let fixture: ComponentFixture<RestauClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestauClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestauClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
