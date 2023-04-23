import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRestaurateurComponent } from './edit-restaurateur.component';

describe('EditRestaurateurComponent', () => {
  let component: EditRestaurateurComponent;
  let fixture: ComponentFixture<EditRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
