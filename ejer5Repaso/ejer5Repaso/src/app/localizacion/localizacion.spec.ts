import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Localizacion } from './localizacion';

describe('Localizacion', () => {
  let component: Localizacion;
  let fixture: ComponentFixture<Localizacion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Localizacion]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Localizacion);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
