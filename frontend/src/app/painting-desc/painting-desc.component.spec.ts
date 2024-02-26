import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaintingDescComponent } from './painting-desc.component';

describe('PaintingDescComponent', () => {
  let component: PaintingDescComponent;
  let fixture: ComponentFixture<PaintingDescComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PaintingDescComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PaintingDescComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
