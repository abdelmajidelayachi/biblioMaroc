import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jwt } from '../configs/jwt';
import { Router } from '@angular/router';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(private router: Router) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = Jwt.getTokenFromLocalStorage();
    if (token) {
      const isTokenExpired = Jwt.checkOfTokenExpiration(token);
      if (isTokenExpired) {
        Jwt.removeTokenFromLocalStorage();
        this.router.navigate(['/authentication']);
      }
    }
    return next.handle(request);
  }
}
