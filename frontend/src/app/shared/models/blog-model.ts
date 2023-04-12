
export interface BlogModel {
  id: number;
  title: string;
  description: string;
  images: string[];
  slug: string;
}

export interface PaginationBlogModel {
  content: BlogModel[];
    totalPages: number;
    totalElements: number;
    size: number;
    numberOfElements: number;
  }