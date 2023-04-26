import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientListCommentaireComponent } from './client-list-commentaire.component';

describe('ClientListCommentaireComponent', () => {
  let component: ClientListCommentaireComponent;
  let fixture: ComponentFixture<ClientListCommentaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientListCommentaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientListCommentaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
