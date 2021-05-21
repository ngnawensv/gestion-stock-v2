import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCommandeClientFournisseurComponent } from './detail-commande-client-fournisseur.component';

describe('DetailCommandeClientFournisseurComponent', () => {
  let component: DetailCommandeClientFournisseurComponent;
  let fixture: ComponentFixture<DetailCommandeClientFournisseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailCommandeClientFournisseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCommandeClientFournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
