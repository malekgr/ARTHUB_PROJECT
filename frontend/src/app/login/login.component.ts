import { Component } from '@angular/core';
import { ProviderService } from '../provider.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  
constructor(public _provider:ProviderService) { }
ngOnInit(): void{
  this._provider.get_users().subscribe(
    res=>{
      console.log(res);
  },
    err=>{
     console.log(err); 
    }
  )
}
}
