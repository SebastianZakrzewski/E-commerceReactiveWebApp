import { Injectable } from '@angular/core';
import {User} from "../User";
import {ApiService} from "./api.service";
import {Router} from "@angular/router";
import {CreateAccountComponent} from "../home/create-account/create-account.component";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService, private router:Router) { }

    userRegister(user:User) {
      this.apiService.create(user, "/user/register").subscribe(
        {
          next: () => {
            this.router.navigate(["home/login"]).then(() => {
              // wprowadzic service do wysylania wiadomosci
            })
          },
          complete: () => {
          }
        });
    }

}


