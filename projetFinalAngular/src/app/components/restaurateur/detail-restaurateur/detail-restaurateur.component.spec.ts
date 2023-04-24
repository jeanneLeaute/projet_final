import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailRestaurateurComponent } from './detail-restaurateur.component';

describe('DetailRestaurateurComponent', () => {
  let component: DetailRestaurateurComponent;
  let fixture: ComponentFixture<DetailRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
