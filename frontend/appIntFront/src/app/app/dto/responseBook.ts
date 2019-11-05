import {Authors} from "./authors";

export class ResponseBook{
  id: string;
  title: string;
  author: string;
  authors: Authors;
  isbn: string;
  year: string;
  publisher: string;
  pages: string;
}
