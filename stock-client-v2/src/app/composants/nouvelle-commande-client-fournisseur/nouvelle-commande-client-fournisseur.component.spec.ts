import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NouvelleCommandeClientFournisseurComponent } from './nouvelle-commande-client-fournisseur.component';

describe('NouvelleCommandeClientFournisseurComponent', () => {
  let component: NouvelleCommandeClientFournisseurComponent;
  let fixture: ComponentFixture<NouvelleCommandeClientFournisseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NouvelleCommandeClientFournisseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NouvelleCommandeClientFournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
