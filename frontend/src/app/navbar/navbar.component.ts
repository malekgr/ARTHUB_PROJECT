import { Component } from '@angular/core';
import { ProviderService } from '../provider.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  constructor(public _provider:ProviderService , public _cart:CartService) { }
}
