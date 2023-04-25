import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMoncompteRestaurateurComponent } from './edit-moncompte-restaurateur.component';

describe('EditMoncompteRestaurateurComponent', () => {
  let component: EditMoncompteRestaurateurComponent;
  let fixture: ComponentFixture<EditMoncompteRestaurateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditMoncompteRestaurateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditMoncompteRestaurateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
