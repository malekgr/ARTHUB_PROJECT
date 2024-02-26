import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProviderService {
  gallery={
    name:'',
    location:"",
    Image:"",
    property:""
  }

  user={
    name:'',
    email:'',
    photo:'',
    paintings:'',
    galleries:''
  }

  email='';
  pwd='';
  
  visitors:any;

  galleries:any[]=[];

  signup=false;
  connected=false;
  username="";
  total=0;
  constructor(private http:HttpClient) { }
  private url='http://localhost:8089/api/v1/'

  get_users(){
    return this.http.get(this.url+'users')
  }
  get_galleries(){
    return this.http.get(this.url+'galleries')
  }
  get_paintings(){
    return this.http.get(this.url+'Article/getArticles')
  }
  login(){
    this.visitors=this.http.get(this.url+'users');
    for (let visitor of this.visitors){
      if (visitor.email == this.email && visitor.password==this.pwd){

      }
    }
  }
}
