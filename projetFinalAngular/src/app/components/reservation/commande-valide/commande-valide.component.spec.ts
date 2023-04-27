import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandeValideComponent } from './commande-valide.component';

describe('CommandeValideComponent', () => {
  let component: CommandeValideComponent;
  let fixture: ComponentFixture<CommandeValideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommandeValideComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommandeValideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
