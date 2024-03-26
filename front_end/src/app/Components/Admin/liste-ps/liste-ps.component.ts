import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/User';
import { UserServiceService } from 'src/app/Services/user-service.service';

@Component({
  selector: 'app-liste-ps',
  templateUrl: './liste-ps.component.html',
  styleUrls: ['./liste-ps.component.css']
})
export class ListePsComponent implements OnInit {

  ps: User[] = [];

  constructor(private userService: UserServiceService, private router: Router) { }

  ngOnInit(): void {
    this.getPs();
  }

  getPs(): void {
    this.userService.getAllUsersNotadmin().subscribe(
      (response) => {
        this.ps = response;
      },
      (error) => {
        console.error('Error fetching adherants:', error);
      }
    );
  }

  hasRoleAdmin(user: User): boolean {
    return user.roles.some(role => role.name === 'ROLE_ADMIN');
  }

}
