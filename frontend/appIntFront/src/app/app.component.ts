import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "./app/dto/book";
import {Observable} from "rxjs";
import {observableToBeFn} from "rxjs/internal/testing/TestScheduler";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private title = 'appIntFront';
  private logo = "exmaple logo";
  private book: Book;

  constructor(private httpClient: HttpClient) { }


  ngOnInit() {
    console.log("test123")
  }


  public getTestData(){
    this.httpClient.get("http://localhost:8080/api/book/oneBook").subscribe((data: any[])=>{
      console.log(data)
    });
  }

  public getTestBook(){
    this.httpClient.get<Book>("http://localhost:8080/api/book/oneBook").subscribe((data: Book)=>{
      this.book = data;
    });
    console.log(this.book.id);
  }

}
