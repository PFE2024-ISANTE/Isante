import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListePsComponent } from './liste-ps.component';

describe('ListePsComponent', () => {
  let component: ListePsComponent;
  let fixture: ComponentFixture<ListePsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListePsComponent]
    });
    fixture = TestBed.createComponent(ListePsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
