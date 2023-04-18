import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { LoginComponent } from './home/login/login.component';
import { HomeComponent } from './home/home.component';
import {AlertModule} from "ngx-bootstrap/alert";
import { CreateAccountComponent } from './home/create-account/create-account.component';
import {Router, RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ControlPanelComponent } from './home/control-panel/control-panel.component';
import { ProductsListComponent } from './home/control-panel/products-list/products-list.component';
import { ProductComponent } from './home/control-panel/products-list/product/product.component';
import {MdbModalModule, MdbModalRef, MdbModalService} from 'mdb-angular-ui-kit/modal';
import { AddProductComponent } from './home/add-product/add-product.component';


  const routes: Routes = [
    {path:'',redirectTo:'home',pathMatch:'full'},
    {path:'home',component:LoginComponent},
    {path:'register',component:CreateAccountComponent},
    {path:'panel',component:ControlPanelComponent}
  ];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CreateAccountComponent,
    ControlPanelComponent,
    ProductsListComponent,
    ProductComponent,
    AddProductComponent,



  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AlertModule,
    FormsModule,
    HttpClientModule,
    MdbModalModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
