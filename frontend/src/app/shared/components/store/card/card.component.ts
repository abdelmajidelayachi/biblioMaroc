import { Component, Input } from '@angular/core';
import { BookModel } from 'src/app/shared/models/book-model';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  
  @Input() book !: BookModel;
  
}
