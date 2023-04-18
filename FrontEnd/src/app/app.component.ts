import { Component } from '@angular/core';
import {UserService} from "./services/user.service";
import {MdbModalService} from "mdb-angular-ui-kit/modal";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [UserService]

})
export class AppComponent {
  constructor(private  modal:MdbModalService) {
  }
  title = 'Front-End';

  register() {

  }

}
