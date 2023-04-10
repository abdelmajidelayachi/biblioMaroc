
export interface UserModel {
  id: number;
  firstname: string;
  lastname: string;
  email: string;
  username: string;
  role : string;
  phone: string;
  avatar: string;
  createdAt: string;
}




export interface PaginationUserModel {
  content: UserModel[];
  totalPages: number;
  totalElements: number;
  size: number;
  numberOfElements: number;
}