import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';
import { UsersDto } from '../../gs-api/src/models/users-dto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  connectedUser:UsersDto={};

  constructor(
    private userService:UserService
  ) { }

  ngOnInit(): void {
    this.connectedUser=this.userService.getConnectedUser();
  }

}
