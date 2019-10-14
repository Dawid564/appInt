import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "./app/dto/book";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private book: Book;
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


  public getTestData() {
    this.httpClient.get("http://localhost:8080/api/book/oneBook").subscribe((data: any[]) => {
      console.log(data)
    });
  }

  public getTestBook() {
    this.httpClient.get<Book>("http://localhost:8080/api/book/oneBook").subscribe((data: Book) => {
      this.book = data;
    });
    console.log(this.book.id);
  }

  public getAllBooks() {
    this.httpClient.get<Book[]>("http://localhost:8080/api/book/allBooks").subscribe((d) => {
      this.books = d;
    });
  }
}
