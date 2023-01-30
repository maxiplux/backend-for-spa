import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditepostComponent } from './editepost.component';

describe('EditepostComponent', () => {
  let component: EditepostComponent;
  let fixture: ComponentFixture<EditepostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditepostComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditepostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
