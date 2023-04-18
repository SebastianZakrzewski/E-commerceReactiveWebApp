import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})

export class ApiService {
  constructor(private http:HttpClient) { }
  private serverAddress = "http://localhost:8080";
  create<T>(data:T, path:string):Observable<T> {
    return this.http.post<T>(`${this.serverAddress}${path}`,data);
  }
  read<T>(id:number,path:string) : Observable<T> {
    return this.http.get<T>(`${this.serverAddress}${path}${id}`);
  }

  update<T>(data:T,id:number,path:string):Observable<T> {
    return this.http.patch<T>(`${this.serverAddress}${path}${id}`,data);
  }
  delete<T>(id:number,path:string): Observable<T> {
    return this.http.delete<T>(`${this.serverAddress}${path}${id}`);
  }

  getListOfObjects<T>(path:string):Observable<T[]>{
    return this.http.get<T[]>(`${this.serverAddress}${path}`);
  }




}
