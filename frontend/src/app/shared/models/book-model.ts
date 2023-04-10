export interface BookModel {
  id: number;
  name: string;
  author: string;
  owner: string;
  price: number;
  numberOfPages: number;
  description: string;
  resume: string;
  images: string[];
  is_deleted: boolean;
  createdAt: string;
  updatedAt: string;
}


export interface PaginationBookModel {
  content: BookModel[];
  totalPages: number;
  totalElements: number;
  size: number;
  numberOfElements: number;
}