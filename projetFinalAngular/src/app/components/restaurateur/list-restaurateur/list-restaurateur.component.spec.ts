import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListRestaurateurComponent } from './list-restaurateur.component';

describe('ListRestaurateurComponent', () => {
  let component: ListRestaurateurComponent;
  let fixture: ComponentFixture<ListRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
