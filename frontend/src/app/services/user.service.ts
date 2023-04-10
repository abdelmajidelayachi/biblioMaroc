import { Injectable } from '@angular/core';
import { PaginationUserModel } from '../shared/models/user-model';
import { HttpClient } from '@angular/common/http';
import { endpoints } from '../shared/constants/endpoint';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUsers(page: number, size: number) {
    return this.http.get<PaginationUserModel>(endpoints.usersPagination(page, size))
  }
}
