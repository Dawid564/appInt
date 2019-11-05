import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Book} from "./app/dto/book";
import {ResponseBook} from "./app/dto/responseBook";
import {Authors} from "./app/dto/authors";

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
    'authors',
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
      console.log(d[0].authors);
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
    let convertedBook = this.convertAuthorToAuthorsList(book);
    console.log(convertedBook);
    this.httpClient.post("http://localhost:8080/api/book/saveBook", convertedBook).subscribe((d) => {
      console.log(d);
    });
  }

  public convertAuthorToAuthorsList(book: ResponseBook){
    let bookAuthor = new Array(1);
    bookAuthor[0] = book.author;
    let authorsList = new Authors();
    authorsList.author = bookAuthor;
    book.authors = authorsList;
    return book;

  }

  public clear(){
    this.books = [];
  }
}
