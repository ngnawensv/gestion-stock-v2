import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageMouvementStockComponent } from './page-mouvement-stock.component';

describe('PageMouvementStockComponent', () => {
  let component: PageMouvementStockComponent;
  let fixture: ComponentFixture<PageMouvementStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageMouvementStockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageMouvementStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
