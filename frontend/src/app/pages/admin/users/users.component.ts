import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { PaginationUserModel } from 'src/app/shared/models/user-model';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  paginationUsers !: PaginationUserModel;

  constructor (private userService: UserService) {
    this.userService.getUsers(0, 10).subscribe((data) => {
      this.paginationUsers = data;
    })
  }
}
