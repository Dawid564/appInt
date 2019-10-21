import {Authors} from "./authors";

export interface Book{
  id: string,
  title: string,
  authors: Authors,
  isbn: string,
  year: string,
  publisher: string,
  pages: string
}
