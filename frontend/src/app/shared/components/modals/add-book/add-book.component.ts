import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FileUploadValidators } from '@iplab/ngx-file-upload';
import { BookService } from 'src/app/services/book.service';


@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent {
  @ViewChild('btnCloseAddBook') addBook: ElementRef | undefined;

   private filesControl: File[] = [];
   bookForm !: FormGroup;
   constructor (private formBuilder: FormBuilder, private bookService: BookService) {

    this.bookForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      author: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      owner: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      price: ['', [Validators.required, Validators.pattern('^[0-9]+(\.[0-9]{1,2})?$')]],
      numberOfPages: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      description: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(500)]],
      images: new FormControl(null, [Validators.required, FileUploadValidators.filesLimit(3)]),
      resume: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(500)]],
    })

   }

    get name() { return this.bookForm.get('name'); }
    get author() { return this.bookForm.get('author'); }
    get owner() { return this.bookForm.get('owner'); }
    get price() { return this.bookForm.get('price'); }
    get numberOfPages() { return this.bookForm.get('numberOfPages'); }
    get description() { return this.bookForm.get('description'); }
    get images() { return this.bookForm.get('images'); }
    get resume() { return this.bookForm.get('resume'); }

    onSubmitSaveBook() {
      console.log(this.bookForm.value);
      
      if(this.bookForm.invalid) {
        return;
      }

      const data = new FormData();
      data.append('name', this.name?.value);
      data.append('author', this.author?.value);
      data.append('owner', this.owner?.value);
      data.append('price', this.price?.value);
      data.append('numberOfPages', this.numberOfPages?.value);
      data.append('description', this.description?.value);
      data.append('resume', this.resume?.value);
      for (let i = 0; i < this.filesControl.length; i++) {
        data.append('images', this.filesControl[i]);
      }
      this.bookService.saveBook(data).subscribe(
        (response) => {
          this.bookForm.reset();
          if(this.addBook)
          this.addBook.nativeElement.click();
        },
        (error) => {
          console.log(error);
          if(this.addBook)
          this.addBook.nativeElement.click();
        }
      )

    }
}
