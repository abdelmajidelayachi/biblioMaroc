import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faLock } from '@fortawesome/free-solid-svg-icons';
import { Jwt } from 'src/app/core/configs/jwt';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent {
   
  loginForm: FormGroup;
  registerForm : FormGroup;

  loginErrorResponse = "";
  registerErrorResponse = "";

  constructor(library: FaIconLibrary, private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
    library.addIcons(faLock);

    // this is form setting forms
    this.registerForm = this.formBuilder.group({
      firstname: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      lastname: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      email: ['', [Validators.required, Validators.email, Validators.minLength(6), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)], Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$')],
      confirmPassword: ['', [Validators.required]],
    });
    this.loginForm = this.formBuilder.group({
      loginEmail: ['', [Validators.required,Validators.email]],
      loginPassword: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]],
    });
  }

  get firstname () { return this.registerForm.get('firstname'); }
  get lastname () { return this.registerForm.get('lastname'); }
  get email () { return this.registerForm.get('email'); }
  get password () {
    return this.registerForm.get('password')
  }
  get confirmPassword() {
    return this.registerForm.get('confirmPassword');
  }

  get loginEmail() {
    return this.loginForm.get('loginEmail');
  }
  get loginPassword() {
    return this.loginForm.get('loginPassword');
  }

  // methods here
  onSubmitLogin() {
    if(this.loginForm.invalid) {
      return;
    }

    const data = {
      email: this.loginEmail?.value,
      password: this.loginPassword?.value
    }

    this.authService.login(data).subscribe(
      (res: any) => {
        this.loginForm.reset();
          Jwt.setTokenToLocalStorage(res.token);
          this.loginErrorResponse = "";
          this.router.navigate(['/home']);
      },
      (err) => {
        console.error(err);
        this.loginErrorResponse = err.error.errors[0]; 
      }
    );
  }

  onSubmitRegister() {
    if(this.registerForm.invalid) {
      return;
    }

    if(this.password?.value !== this.confirmPassword?.value) {
      this.confirmPassword?.setErrors({notMatch: true});
      return;
    }
    const data = {
      firstname: this.firstname?.value,
      lastname: this.lastname?.value,
      email: this.email?.value,
      password: this.password?.value,
      confirmPassword: this.confirmPassword?.value
    }

    this.authService.register(data).subscribe(
      (res: any) => {
          console.log(res)
          this.registerForm.reset();
          Jwt.setTokenToLocalStorage(res.token);
          this.router.navigate(['/home']);
        
      },
      (err) => {
        console.error(err);
        this.registerErrorResponse = err.error.errors[0]
      }
    );
  }
  

}
