import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterPsComponent } from './ajouter-ps.component';

describe('AjouterPsComponent', () => {
  let component: AjouterPsComponent;
  let fixture: ComponentFixture<AjouterPsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AjouterPsComponent]
    });
    fixture = TestBed.createComponent(AjouterPsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
