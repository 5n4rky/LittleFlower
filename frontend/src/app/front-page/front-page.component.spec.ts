import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontPageComponent } from './front-page.component';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css'] // Add the CSS file here
})


describe('FrontPageComponent', () => {
  let component: FrontPageComponent;
  let fixture: ComponentFixture<FrontPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FrontPageComponent]
    });
    fixture = TestBed.createComponent(FrontPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
