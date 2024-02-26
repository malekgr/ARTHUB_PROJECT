import { Component } from '@angular/core';
import { ProviderService } from '../provider.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
constructor(public _provider:ProviderService ) { }
}
