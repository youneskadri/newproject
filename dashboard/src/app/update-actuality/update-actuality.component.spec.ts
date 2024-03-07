import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateActualityComponent } from './update-actuality.component';

describe('UpdateActualityComponent', () => {
  let component: UpdateActualityComponent;
  let fixture: ComponentFixture<UpdateActualityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateActualityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateActualityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
