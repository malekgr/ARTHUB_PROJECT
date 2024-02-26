import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GalleryDescComponent } from './gallery-desc.component';

describe('GalleryDescComponent', () => {
  let component: GalleryDescComponent;
  let fixture: ComponentFixture<GalleryDescComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GalleryDescComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GalleryDescComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
