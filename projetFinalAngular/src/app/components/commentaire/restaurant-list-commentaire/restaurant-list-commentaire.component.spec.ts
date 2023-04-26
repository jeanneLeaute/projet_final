import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantListCommentaireComponent } from './restaurant-list-commentaire.component';

describe('RestaurantListCommentaireComponent', () => {
  let component: RestaurantListCommentaireComponent;
  let fixture: ComponentFixture<RestaurantListCommentaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantListCommentaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestaurantListCommentaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
