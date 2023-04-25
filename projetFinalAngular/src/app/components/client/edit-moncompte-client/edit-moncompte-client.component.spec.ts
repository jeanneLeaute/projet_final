import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMoncompteClientComponent } from './edit-moncompte-client.component';

describe('EditMoncompteClientComponent', () => {
  let component: EditMoncompteClientComponent;
  let fixture: ComponentFixture<EditMoncompteClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditMoncompteClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditMoncompteClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
