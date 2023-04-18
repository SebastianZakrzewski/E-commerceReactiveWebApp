import { Component } from '@angular/core';
import {User} from "../../User";
import {ApiService} from "../../services/api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css'],
})
export class CreateAccountComponent {
  pending: boolean = false;
  constructor(private apiService: ApiService, private router:Router) {
  }
  user : User = {name: '', lastname: '', email: '', password: ''};

  registerAccount() {
      this.apiService.create(this.user, "/user/register").subscribe(
        {
          next: () => {
            this.router.navigate(["home"]).then(() => {
              // wprowadzic service do wysylania wiadomosci
            })
          },
          complete: () => {
            this.pending = false;
          }
        });
    }


}
