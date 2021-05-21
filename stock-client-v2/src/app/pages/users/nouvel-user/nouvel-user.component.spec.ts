import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NouvelUserComponent } from './nouvel-user.component';

describe('NouvelUserComponent', () => {
  let component: NouvelUserComponent;
  let fixture: ComponentFixture<NouvelUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NouvelUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NouvelUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
