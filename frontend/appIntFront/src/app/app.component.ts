import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Book} from "./app/dto/book";
import {ResponseBook} from "./app/dto/responseBook";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public books: Book[];
  public head = 'yolo';
  public tableHead = [
    'id',
    'title',
    'author',
    'isbn',
    'year',
    'publisher',
    'pages'
  ];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
  }

  public getAllBooks() {
    this.httpClient.get<Book[]>("http://localhost:8080/api/book/allBooks").subscribe((d) => {
      this.books = d;
    });
  }

  public getAllByTittle(bookTittle) {
    this.httpClient.get<Book[]>("http://localhost:8080/api/book/searchByTitle/" + bookTittle).subscribe((d) => {
      this.books = d;
    });
  }

  public getAllByAuthor(author) {
    this.httpClient.get<Book[]>("http://localhost:8080/api/book/searchByAuthor/" + author).subscribe((d) => {
      this.books = d;
    });
  }

  public getAllByISBN(isbn) {
    this.httpClient.get<Book>("http://localhost:8080/api/book/searchByISBN/" + isbn).subscribe((d) => {
      this.books = [d];
    });
  }

  public addNewBook(book: ResponseBook){
    this.httpClient.post("http://localhost:8080/api/book/saveBook", book).subscribe((d) => {
      console.log(d);
    });
  }

  public clear(){
    this.books = [];
  }
}
