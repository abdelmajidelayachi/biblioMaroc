import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { endpoints } from '../shared/constants/endpoint';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(formData: any) {
    return this.http.post(endpoints.login, formData);
  }

  register(formData: any) {
    return this.http.post(endpoints.register, formData);
  }
}
